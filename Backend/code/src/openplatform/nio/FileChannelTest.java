package openplatform.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;


/**
 * filechannel 是块式传递，区别与流式存储
 */
public class FileChannelTest {

    public static void  main(String[] args){


        String file = "./test_write_using_filechannel.txt";
        try {
            RandomAccessFile writer = new RandomAccessFile(file, "rw");
            FileChannel fileChannel=writer.getChannel() ;
            ByteBuffer byteBuffer = ByteBuffer.wrap("Hello world".getBytes(StandardCharsets.UTF_8));

            fileChannel.write(byteBuffer);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
