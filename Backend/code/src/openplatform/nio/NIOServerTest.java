package openplatform.nio;


import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yangyibo
 * Date: 2019/9/29
 * Time: 上午12:41
 */
public class NIOServerTest {


	public static void main(String[] args) throws Exception{
		Selector selector = Selector.open();


		//socketChaneel 注册到seletor上
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		ServerSocket serverSocket = serverSocketChannel.socket();
		InetSocketAddress address=new InetSocketAddress("127.0.0.1",8888);
		serverSocket.bind(address);

		while(true){
			selector.select();
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key=iterator.next();
				if(key.isAcceptable()){
					ServerSocketChannel channel = (ServerSocketChannel)key.channel();
					SocketChannel acceptChannel = channel.accept();
					acceptChannel.configureBlocking(false);
					acceptChannel.register(selector,SelectionKey.OP_READ);
					System.out.println(" socket channel connected ! ");

				}else if(key.isReadable()){
					SocketChannel socketChannel=(SocketChannel) key.channel();
					System.out.println(readDataFromChannel(socketChannel));
					socketChannel.close();

				}
			}
			iterator.remove();


		}



	}


	private static String readDataFromChannel(SocketChannel socketChannel) throws Exception{
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		StringBuilder ret=new StringBuilder();
		while(true){

			buffer.clear();
			int read = socketChannel.read(buffer);
			if(read==-1){
				break;
			}
			buffer.flip();
			int limit = buffer.limit();
			char[] dest=new char[limit];
			for(int i=0;i<limit;i++){
				dest[i]=(char) buffer.get(i);
			}
			ret.append(dest);
			buffer.clear();
		}

		return ret.toString();
	}


}
