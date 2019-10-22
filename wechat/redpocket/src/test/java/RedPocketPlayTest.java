import model.NormalModel;
import model.PlayModel;
import model.RandomModel;
import org.junit.Before;
import org.junit.Test;


import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yangyibo
 * Date: 2019/10/22
 * Time: 下午7:29
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


	private  static  volatile RandomModel randomModel;
	public static RandomModel getModel(int num,double money) throws Exception {
		if(randomModel==null){
			synchronized (RandomModel.class){
				if(randomModel==null){
					randomModel=new RandomModel(num,money);
				}
			}
		}

		return  randomModel;
	}



	// 红包发布者
	class Publisher extends Thread {

		int pocketNum;
		double money;
		Publisher(int pocketNum,double money){
			this.pocketNum=pocketNum;
			this.money=money;
		}

		public void run() {
			try{
				getModel(pocketNum,money);
			}catch (Exception e){
				System.out.println("发红包异常");
				e.printStackTrace();
				System.exit(-1);

			}


		}
	}


	// 抢红包者
	class Subscriber extends Thread {
		String name;
		Subscriber(String name){
			this.name=name;
		}

		public void run() {
			//多线程保证数据同步
			try{
				double mm = randomModel.generate();
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





	@Before
	public void init() throws Exception{
		initPocketNum10();
		initMoney1000();
		initGroupCase10();

	}

	/**
	 * 红包个数10+
	 */
	void initPocketNum10(){
		pocketNum=10;
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
		money=5;
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
	void initGroupCase10(){
		groupNum=10;
	}

	/**
	 * 微信群人数100+
	 */
	void initGroupCase100(){
		groupNum=100;
	}

	/**
	 * 微信群人数1000+
	 */
	void initGroupCase1000(){
		groupNum=1000;
	}


	@Test
	public void pubSubTest(){

		try{
			// 发布且成功
			Publisher publisher = new Publisher(pocketNum,money);
			publisher.start();
			publisher.join();
			System.out.println("发红包成功! 红包个数 "+pocketNum +" 红包大小 "+money);

			//  开始抢红包

			final CountDownLatch latch= new CountDownLatch(groupNum);
			for(int i=0;i<groupNum;i++){
				int tt = new Random().nextInt(5);
				Thread.sleep(tt*1000);
				Subscriber subscriber = new Subscriber("thread-" + i);
				subscriber.start();
				latch.countDown();
			}

			latch.await();


		}catch (Exception e){
			e.printStackTrace();
		}



	}








}
