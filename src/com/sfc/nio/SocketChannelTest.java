package com.sfc.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by Prophet on 2017/9/6.
 */
public class SocketChannelTest {

    private static final int BUF_SIZE=1024;
    private static final int PORT = 8080;

    public static void client() {
        ByteBuffer buffer = ByteBuffer.allocate(BUF_SIZE);
        SocketChannel socketChannel = null;

        try {
            //打开SocketChannel
            socketChannel = SocketChannel.open();
            //配置为非阻塞模式
            socketChannel.configureBlocking(false);
            //连接端口
            socketChannel.connect(new InetSocketAddress("127.0.0.1",PORT));
            if (socketChannel.finishConnect()){
                int i = 0;
                //写入数据
                while (true){
                    TimeUnit.SECONDS.sleep(1l);
                    String info = "I'm "+i+++"-th information from client";
                    //向 buffer 中写数据
                    buffer.clear();
                    buffer.put(info.getBytes());
                    //从 buffer 中读数据
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        System.out.println(buffer);
                        //这里要放在循环中，Write()方法无法保证能写多少字节到SocketChannel。所以，我们重复调用write()直到Buffer没有要写的字节为止。
                        socketChannel.write(buffer);
                    }
                    if (i == 100){
                        i=0;
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (socketChannel != null){
                try {
                    //关闭连接
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        client();
    }

}
