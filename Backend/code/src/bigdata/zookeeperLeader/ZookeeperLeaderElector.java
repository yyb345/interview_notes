package bigdata.zookeeperLeader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangyibo
 * Date: 2019/7/14
 * Time: 下午3:50
 */


public class ZookeeperLeaderElector{




	/************************************线程间进行通信********************************
	 /**
	 * 发往谁（谁发的，投票信息）
	 */
	private static Map<Integer,Queue<Map<Integer, Broker.Vote>>> sharedReceiveVote = new ConcurrentHashMap<>();
	int totalNum=3;


	/**
	 * 源broker给目的broker发送投票信息
	 */
	public  void sendToVote(Broker.Vote vote, int sourceBrokerId, int destBrokerId){
		Map<Integer,Broker.Vote> votes=new HashMap<>();
		votes.put(sourceBrokerId,vote);
		Queue<Map<Integer, Broker.Vote>> head = sharedReceiveVote.get(destBrokerId);
		if(head!=null){
			head.add(votes);
		}else {
			head=new ArrayDeque<>();
			head.add(votes);
		}
		sharedReceiveVote.put(destBrokerId,head);
	}

	/**
	 * 向其他节点广播数据
	 * @param sourceId
	 * @param vote
	 */
	public void broadCastVotes(int sourceId,Broker.Vote vote){

		synchronized (this){
			if(sharedReceiveVote.get(sourceId)==null){
				sharedReceiveVote.put(sourceId,new ArrayDeque<>());
			}
			for(int broker:sharedReceiveVote.keySet()){
				if(broker!=sourceId){
					sendToVote(vote,sourceId,broker);
				}
			}
		}

	}


	  class Broker extends Thread {



	 /**
	  * 初始化
	  *
	  * @param brokerId
	  */
	 public Broker(int brokerId) {
		 this.brokerId = brokerId;
		 this.logicLock = new AtomicInteger(0);
		 this.dataId = 0;
		 this.sendVote = new Vote(brokerId, new AtomicInteger(0), 0);
	 }
	 public Broker(int brokerId,int logicLock) {
			this.brokerId = brokerId;
			this.logicLock = new AtomicInteger(logicLock);
			this.dataId = 0;
			this.sendVote = new Vote(brokerId, new AtomicInteger(0), 0);
	 }


	 /**
	  * 当前所有的节点数量
	  */
	 private  volatile int allBrokerNum = 1;

	  class Vote {


		 public Vote(int voteForBrokerId, AtomicInteger logicLock, long dataId) {
			 this.voteForBrokerId = voteForBrokerId;
			 this.logicLock = logicLock;
			 this.dataId = dataId;
		 }

		 /**
		  * 投票给谁的节点Id
		  */
		 private int voteForBrokerId;

		 /**
		  * 第几轮投票
		  */
		 private AtomicInteger logicLock;

		 /**
		  * 数据ID
		  */
		 private long dataId;

		 public int getVoteForBrokerId() {
			 return voteForBrokerId;
		 }

		 public void setVoteForBrokerId(int voteForBrokerId) {
			 this.voteForBrokerId = voteForBrokerId;
		 }

		 public AtomicInteger getLogicLock() {
			 return logicLock;
		 }

		 public void setLogicLock(AtomicInteger logicLock) {
			 this.logicLock = logicLock;
		 }

		 public long getDataId() {
			 return dataId;
		 }

		 public void setDataId(long dataId) {
			 this.dataId = dataId;
		 }

		  @Override
		  public String toString() {
			  return "voteForBrokerId:"+ this.voteForBrokerId+" "+"logicLock:"+this.logicLock.get()+" "+" dataId:"+this.dataId;
		  }
	 }

	 /**
	  * 当前节点的ID
	  */

	 private int brokerId;

	 /**
	  * 当前的投票轮次
	  */
	 private AtomicInteger logicLock;

	 /**
	  * 当前的dataId
	  */
	 private long dataId;


	 /**
	  * 当前的角色状态 属于投票中、follwer还是leader
	  */
	 private  int currentState = ElectorState.LOOKING;


	 /**
	  * 选举是否结束
	  */
	 private boolean stop = false;



	 /*************************************************************************给别人的投票********************************
	  /**
	  * 发送给别人的投票信息
	  */
	 private Vote sendVote;



	 /**
	  * 程序执行
	  */

	 @Override
	 public void run() {

		 while (true) {
			 switch (currentState) {
				 case ElectorState.LOOKING:
					 VoteLeader();
					 break;
				 case ElectorState.FOLLOWING:
					 break;
				 case ElectorState.LEADERING:
					 LeaderProcess();
					 break;
				 case ElectorState.OBSERVING:
					 break;
			 }

		 }

	 }



		  /**
		   * 发送leader信息
		   */
	 public void LeaderProcess(){
		 broadCastVotes(brokerId,sendVote);
	 }


	 /**
	  * 投票选举的过程
	  */
	 public void VoteLeader() {


		 //投票轮次增加
		 logicLock.incrementAndGet();
		 Map<Integer, Integer> voteIds = new HashMap<>();
		 //如果在投票中则进行下列投票过程
		 while (!stop) {




			 Queue<Map<Integer, Vote>> receiveVote = sharedReceiveVote.get(brokerId);


			 if (receiveVote != null) {

				 Map<Integer, Vote> poll = receiveVote.poll();

			 	if(poll!=null){
				    //根据接收到的投票信息进行投票
				    for (Map.Entry<Integer, Vote> voteEntry : poll.entrySet()) {


					    int receiveId = voteEntry.getKey();
					    Vote value = voteEntry.getValue();
					    System.out.println(brokerId+ " 收到 " + receiveId + " 的投票" + value.toString());

					    if (value.logicLock.get() > logicLock.get()) {
						    //重置自己的投票轮次
						    logicLock.set(value.logicLock.get());
						    sendVote.setLogicLock(value.logicLock);
						    sendVote.setVoteForBrokerId(value.voteForBrokerId);
						    sendVote.setDataId(value.dataId);
						    voteIds.put(sendVote.voteForBrokerId, voteIds.getOrDefault(sendVote.voteForBrokerId, 0) + 1);

					    } else if (value.logicLock.get() == logicLock.get()) {
						    if (value.dataId > dataId) {
							    dataId = value.dataId;
							    sendVote.setVoteForBrokerId(value.voteForBrokerId);
							    sendVote.setDataId(value.dataId);
							    voteIds.put(sendVote.voteForBrokerId, voteIds.get(sendVote.voteForBrokerId) + 1);
							 //   System.out.println("-----"+sendVote.voteForBrokerId);

						    } else if (value.dataId == dataId) {
							    if (value.voteForBrokerId >= sendVote.voteForBrokerId) {
								    sendVote.voteForBrokerId = value.voteForBrokerId;
								    voteIds.put(sendVote.voteForBrokerId, voteIds.getOrDefault(sendVote.voteForBrokerId, 0) + 1);
							    }
						    }
					    }

					    broadCastVotes(brokerId,sendVote);

				    }
			    }else{
				    broadCastVotes(brokerId,sendVote);
				   // voteIds.put(sendVote.voteForBrokerId, voteIds.getOrDefault(sendVote.voteForBrokerId, 0) + 1);
			    }



		 }else{
			 	 sendVote.voteForBrokerId=brokerId;
			 	 sendVote.dataId=dataId;
				 sendVote.logicLock=logicLock;
				 System.out.println(brokerId+" 给自己投票:"+brokerId);
				 broadCastVotes(brokerId, sendVote);
				 voteIds.put(brokerId,1);
			 }




			 //判断终止条件是否满足

			 for (Map.Entry<Integer, Integer> v : voteIds.entrySet()) {
				// System.out.println(brokerId+" 投票结果 <"+v.getKey()+","+v.getValue()+">");
				 if (v.getValue() > (totalNum / 2 )) {
					 stop = true;
					 if(v.getKey()==brokerId){
					 	currentState=ElectorState.LEADERING;
					 }else{
					 	currentState=ElectorState.FOLLOWING;
					 }
					 System.out.println(brokerId+" final leader is " + v.getKey());
				 }
			 }

			 try {
				 Thread.sleep(4000l);
			 }catch (Exception e){
			 	e.printStackTrace();
			 }

		 }


	 }

		@Override
		public String toString() {
			return "brokeId:"+ brokerId+" "+"logicLock:"+logicLock.get()+" "+" dataId:"+dataId;
		}
	}

 public  void execute() throws Exception{

	 Broker broker1 = new Broker(1,5);
	 broker1.start();

	 Thread.sleep(4000l);

	  Broker broker2 = new Broker(2,10);
	 broker2.start();
	 Thread.sleep(4000l);

	 Broker broker3 = new Broker(3,8);
	 broker3.start();
	 Thread.sleep(4000l);


//	 broker1.stop();
//	 broker2.stop();
//	 broker3.stop();



 }

	public static void main(String[] args) throws Exception{

		new ZookeeperLeaderElector().execute();
	}


}
