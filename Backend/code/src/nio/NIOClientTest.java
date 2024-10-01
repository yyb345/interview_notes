package nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by yangyibo
 * Date: 2019/9/29
 * Time: 上午12:57
 */
public class NIOClientTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 8888));

		while (!socketChannel.finishConnect()) {
			// 等待连接建立
		}

		// 发送数据到服务器
		String message = "Hello, server!";
		ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
		socketChannel.write(buffer);

		System.out.println("I have send request to server,Now I am waiting");
		// 等待一段时间，模拟客户端继续执行其他操作
		//Thread.sleep(2000);

		// 读取服务器返回的数据
		ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
		socketChannel.read(responseBuffer);
		responseBuffer.flip();
		byte[] responseData = new byte[responseBuffer.remaining()];
		responseBuffer.get(responseData);
		System.out.println("Received response from server: " + new String(responseData));

		socketChannel.close();
	}
}
