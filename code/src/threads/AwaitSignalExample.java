package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangyibo
 * Date: 2019/5/4
 * Time: 下午3:18
 */
public class AwaitSignalExample {

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void before() {
		lock.lock();
		try {
			System.out.println("before");
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void after() {
		lock.lock();
		try {
			condition.await();
			System.out.println("after");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CountDownLatch countDownLatch = new CountDownLatch(2);
		AwaitSignalExample example = new AwaitSignalExample();
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
