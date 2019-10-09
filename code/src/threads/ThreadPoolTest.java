package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by yangyibo
 * Date: 2019/9/22
 * Time: 下午1:19
 */
public class ThreadPoolTest {

	static final int MAXIMUM_CAPACITY = 1 << 30;
	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

	public static void main(String[] args){


		System.out.println(tableSizeFor(40));
//		ExecutorService executorService = Executors.newFixedThreadPool(10);

	}
}
