package threads;

/**
 * Created by yangyibo
 * Date: 2019/5/5
 * Time: 上午11:00
 */

public class SyncWaitBlock implements Runnable {


	Object lock;
	SyncWaitBlock(Object lock){
		lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock){
			try {
				System.out.println("xxx");
				lock.wait();
				System.out.println("notify");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}


	}





}

