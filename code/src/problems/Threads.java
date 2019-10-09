package problems;

import org.junit.Test;

import java.util.concurrent.*;

/**
 *
 * Created by yangyibo
 * Date: 2019/3/29
 * Time: 下午11:37
 */


public class Threads {




	volatile int globalNum=10;

	class thread implements Runnable{
		int threadNum;
		thread(int num){
			this.threadNum=num;
		}
		@Override
		public void run(){
//			try{
//				Thread.sleep(threadNum*1000);
//			}catch (Exception e){
//				e.printStackTrace();
//			}

			System.out.println(threadNum+" completed!");
		}
	}

	volatile  boolean stop=false;

	class thread1 implements Runnable{
		int threadNum;
		thread1(int num){
			this.threadNum=num;
		}
		@Override
		public void run(){

			while(!stop){
				System.out.println("1");
			}

			//System.out.println(threadNum+" completed!");
		}
	}

	class thread2 implements Runnable{
		int threadNum;
		thread2(int num){
			this.threadNum=num;
		}
		@Override
		public void run(){


		System.out.println("2");
		stop=true;


			//System.out.println(threadNum+" completed!");
		}
	}



	@Test
	public void volitleTest() throws Exception{
		CountDownLatch countDownLatch=new CountDownLatch(2);
		ExecutorService threadPoolExecutor= Executors.newCachedThreadPool();
		threadPoolExecutor.submit(new thread1(1));
		countDownLatch.countDown();
		threadPoolExecutor.submit(new thread2(2));
		countDownLatch.countDown();

		System.out.println("Finish ");

	}



	public volatile int inc = 0;

	synchronized public void increase() {
		inc++;
	}

	//AtomicInteger

	@Test
	public void volatileTest(){
		Threads threads=new Threads();
		for(int i=0;i<10;i++){
			new Thread(){
				public void run() {
					//Thread.sleep();
					for(int j=0;j<1000;j++)
						threads.increase();
				};
			}.start();
		}

		while(Thread.activeCount()>1)  //保证前面的线程都执行完
			Thread.yield();
		System.out.println(threads.inc);
	}


	@Test
	public void  CountDownLatchTest() throws Exception{
		int threadNum=10;
		CountDownLatch countDownLatch=new CountDownLatch(threadNum);
		ExecutorService threadPoolExecutor= Executors.newCachedThreadPool();


		for(int i=0;i<threadNum;i++){
			threadPoolExecutor.submit(new thread(i));
			countDownLatch.countDown();
		}

		countDownLatch.await();
		System.out.println("end");
		threadPoolExecutor.shutdownNow();

	}



	@Test
	public void CyclicBarrierTest() throws Exception{
		int threadNum=10;
		//FutureTask
		CyclicBarrier cyclicBarrier=new CyclicBarrier(threadNum);
		ExecutorService executorService=Executors.newCachedThreadPool();

		for(int i=0;i<threadNum;i++){
			executorService.submit(()->{
				try{
					cyclicBarrier.await();
					System.out.println(" after");
				}catch (Exception e){
					e.printStackTrace();
				}

			});


		}
		executorService.shutdownNow();
	}



}
