package nio;

import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by yangyibo
 * Date: 2019/9/29
 * Time: 上午12:57
 */
public class NIOClientTest {

	public static void main(String[] args) throws  Exception{

		Socket socket=new Socket("127.0.0.1",8888);
		OutputStream outputStream = socket.getOutputStream();
		String data="Hello World";
		outputStream.write(data.getBytes());
		outputStream.close();
	}
}
