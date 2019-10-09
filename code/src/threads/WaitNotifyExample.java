package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangyibo
 * Date: 2019/5/4
 * Time: 下午2:08
 */
public class WaitNotifyExample {

	public synchronized void before() {
		System.out.println("before");
		try{
			//Thread.sleep(2000);

		}catch (Exception e){
			e.printStackTrace();
		}

		notifyAll();
	}

	public synchronized void after() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after");
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CountDownLatch countDownLatch = new CountDownLatch(3);
		WaitNotifyExample example = new WaitNotifyExample();
		executorService.execute(() ->{
			try{
				example.after();
				countDownLatch.countDown();

			}catch (Exception e){
				e.printStackTrace();
			}

		} );
		executorService.execute(
				() ->{
					try{
						example.after();
						countDownLatch.countDown();
					}catch (Exception e){
						e.printStackTrace();
					}

				}
						);
		executorService.execute(
				() ->{
					try{
						example.before();
						countDownLatch.countDown();
					}catch (Exception e){
						e.printStackTrace();
					}

				}
		);


		countDownLatch.await();
		executorService.shutdownNow();


	}
}
