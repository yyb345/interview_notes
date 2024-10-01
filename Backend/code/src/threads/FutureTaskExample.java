package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangyibo
 * Date: 2019/4/9
 * Time: 下午3:16
 */
public class FutureTaskExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int result = 0;
				for (int i = 0; i < 100; i++) {
					Thread.sleep(100);
					//System.out.println("comute task is running...");
					result += i;
				}
				return result;
			}
		});

		Thread computeThread = new Thread(futureTask);
		computeThread.start();


		Thread otherThread = new Thread(() -> {
			System.out.println("other task is running...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		otherThread.start();
		try{
		//	computeThread.join();
			System.out.println(futureTask.isDone());
			futureTask.get();
			//System.out.println(futureTask.get());
			System.out.println(futureTask.isDone());

		}catch (Exception e){
			e.printStackTrace();
		}


	}
}
