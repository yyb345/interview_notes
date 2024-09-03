package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

	static class Message {
		private String content;

		public Message(String content) {
			this.content = content;
		}

		public String getContent() {
			return content;
		}
	}
	public static void main(String[] args){


		Message message = new Message("Hello, World!");

		// 生产者线程
		Thread producerThread = new Thread(() -> {
			synchronized (message) {
				System.out.println("Producer Thread generated a message: " + message.getContent());
				message.notify(); // 通知等待的消费者线程
			}
		});

		// 消费者线程
		Thread consumerThread = new Thread(() -> {
			synchronized (message) {
				try {
					System.out.println("wait");
					message.wait(); // 等待生产者线程通知
					System.out.println("Consumer Thread consumed the message: " + message.getContent());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// 启动消费者线程
		consumerThread.start();

		// 启动生产者线程
		producerThread.start();

	}
}
