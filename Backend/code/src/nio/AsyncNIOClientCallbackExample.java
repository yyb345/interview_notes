package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class AsyncNIOClientCallbackExample {

    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            client.connect(new InetSocketAddress("127.0.0.1", 8888)).get();

            // 发送消息给服务端
            String message = "requestId:123";
            ByteBuffer sendbuffer = ByteBuffer.wrap(message.getBytes());
            client.write(sendbuffer).get(); // 发送消息给服务端

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            client.read(buffer, null, new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    buffer.flip();
                    String responseData = new String(buffer.array(), 0, buffer.limit());
                    System.out.println("Received callback message from server: " + responseData + " "+Thread.currentThread().getId());
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println("Failed to receive callback message from server");
                }
            });

            System.out.println("I have send a request to server,I do my other things now! "+Thread.currentThread().getId());
            System.in.read(); // 等待客户端保持运行

        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
