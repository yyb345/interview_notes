package openplatform.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AsyncNIOServerCallbackExample {

    public static void main(String[] args) {
        try {
            AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress("127.0.0.1", 8888));

            server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
                @Override
                public void completed(AsynchronousSocketChannel client, Void attachment) {
                    server.accept(null, this); // 接受下一个连接请求

                    // 给客户端发起一个回调
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ByteBuffer buffer = ByteBuffer.wrap("Hello from server!".getBytes());
                    client.write(buffer, null, new CompletionHandler<Integer, Object>() {
                        @Override
                        public void completed(Integer result, Object attachment) {
                            System.out.println("Callback message sent to client");
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            System.out.println("Callback message sending failed");
                        }
                    });
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    // 接受连接请求失败
                }
            });

            System.in.read(); // 等待服务器保持运行

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}