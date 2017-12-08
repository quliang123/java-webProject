package javaDemo.nio;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 123 on 2017/10/21.
 */

public class nio1 {
    /**
     * 得到channel
     * 申请buffer
     * 建立Channel和buffer的关系
     * 关闭
     *
     * @throws FileNotFoundException
     */
    @Test
    public void n1() throws FileNotFoundException {
        FileInputStream file = new FileInputStream(new File("E:\\123\\hs_err_pid26268.log"));
        try {
            FileChannel channel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            channel.close();
            byteBuffer.flip();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝文件
     *
     * @throws IOException
     */
    @Test
    public void n2() throws IOException {
        FileInputStream inputStream = new FileInputStream("E:\\UnrarSrc.txt");
        FileOutputStream outputStream = new FileOutputStream("E:\\a.txt");
        FileChannel readChannel = inputStream.getChannel();
        FileChannel writeChannel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            buffer.clear();    //在读取文件时，清除缓冲区
            System.out.println("=============" + buffer);
            int len = readChannel.read(buffer);

            System.out.println("len" + len);
            if (len == -1) {
                break;
            }
            buffer.flip();   //读取数据时    反转
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }

    @Test
    public void n3() {
        ByteBuffer b = ByteBuffer.allocate(15); // 15个字节大小的缓冲区
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        for (int i = 0; i < 10; i++) {
            // 存入10个字节数据
            b.put((byte) i);
        }
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        b.flip(); // 重置position
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        for (int i = 0; i < 5; i++) {
            System.out.print(b.get());
        }
        System.out.println();
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
        b.flip();
        System.out.println("limit=" + b.limit() + " capacity=" + b.capacity()
                + " position=" + b.position());
    }
}