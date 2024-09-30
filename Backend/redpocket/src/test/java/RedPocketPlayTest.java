import model.NormalModel;
import model.PlayModel;
import model.RandomModel;
import org.junit.Before;
import org.junit.Test;


import java.util.concurrent.CountDownLatch;


/**
 * Created by yangyibo
 * Date: 2019/10/22
 * Time: 下午7:29
 * 这个类用来测试抢红包整个流程以及多种模式、各种线程级别
 */
public class RedPocketPlayTest {


	/**
	 * 红包个数
	 */
	private static int pocketNum=4;
	/**
	 * 单个红包或者总红包数
	 */
	private double money=10;
	/**
	 * 微信群人数
	 */
	private  int groupNum=10;

	/**
	 * 发红包模式
	 */
	private  static  volatile PlayModel playModel;

	/**
	 * 抢红包的线程，代表微信群朋友
	 */
	private Subscriber[] subscribers;


	/**
	 * 发红包信号
 	 */

	private final CountDownLatch  pubRedPocket = new CountDownLatch(1);


	/**
	 * 抢红包线程
 	 */

	class Subscriber extends Thread {
		String name;
		Subscriber(String name){
			this.name=name;
		}

		public void run() {
			try{
				System.out.println(name+" 等待抢红包");
				pubRedPocket.await();
				double mm =playModel.generate();
				if(mm==0.0){
					System.out.println(name+" 红包已经抢完! ");
				}else {
					System.out.println(name+" 抢到红包 "+mm);
				}

			}catch (Exception e){
				e.printStackTrace();
			}


		}
	}



	/**
	 * 初始化各种场景case
	 * @throws Exception
	 */
	@Before
	public void init() throws Exception{

		// 红包个数
		initPocketNum10();
		//initPocketNum100();
		//initPocketNum1000();

		initMoney10();
		//initMoney100();
		//initMoney1000();

		//微信群人数
		//initGroupNum10();
		initGroupNum100();
		//initGroupNum1000();

		// 发红包与抢红包先后启动
		//publishBeforeSubsciber();
		SubsciberBeforePublish();

	}



	/**发红包流程测试 场景测试都在init里设置
	 */
	@Test
	public void redPocketTest(){
		try{

			// finalize
			for(int i=0;i<groupNum;i++){
				subscribers[i].join();
			}

		}catch (Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}



//各种场景
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 发红包在抢红包之前
	 */
	void publishBeforeSubsciber(){
		initRandomModel();
		initSubsciber();
	}


	/**抢红包在发红包之前
	 *
	 */
	void SubsciberBeforePublish(){
		initSubsciber();
		initRandomModel();

	}


	/**
	 * 开始抢红包
	 */

	void initSubsciber(){

		subscribers=new Subscriber[groupNum];
		for(int i=0;i<groupNum;i++){
			Subscriber sub = new Subscriber("friend-" + i);
			subscribers[i]=sub;
			subscribers[i].start();
		}
	}



	/**
	 * 发拼手气红包
	 */
	void initRandomModel(){
		try{
			playModel=new RandomModel(pocketNum,money);
			System.out.println(" 发拼手气红包 个数 "+ pocketNum +" 总大小 "+money );
			pubRedPocket.countDown();

		}catch (Exception e){
			System.exit(-1);
			e.printStackTrace();
		}

	}

	/**
	 * 发普通红包
	 */
	void initNormalModel(){
		try{
			playModel=new NormalModel(pocketNum,money);
			System.out.println(" 发普通红包 个数 "+ pocketNum +" 大小 "+money );
			pubRedPocket.countDown();
		}catch (Exception e){
			System.exit(-1);
			e.printStackTrace();
		}

	}


	/**
	 * 红包个数10+
	 */
	void initPocketNum10(){
		pocketNum=4;
	}
	/**
	 * 红包个数100+
	 */
	void initPocketNum100(){
		pocketNum=100;
	}

	/**
	 * 红包个数1000+
	 */
	void initPocketNum1000(){
		pocketNum=1000;
	}

	/**
	 * 红包大小10+
	 */
	void initMoney10(){
		money=10;
	}

	/**
	 * 红包大小100+
	 */
	void initMoney100(){
		money=100;
	}

	/**
	 * 红包大小1000+
	 */
	void initMoney1000(){
		money=1000;
	}


	/**
	 * 微信群人数10+
	 */
	void initGroupNum10(){
		groupNum=10;
	}

	/**
	 * 微信群人数100+
	 */
	void initGroupNum100(){
		groupNum=100;
	}

	/**
	 * 微信群人数1000+
	 */
	void initGroupNum1000(){
		groupNum=1000;
	}


}
