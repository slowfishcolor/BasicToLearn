package com.sfc.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Prophet on 2017/9/6.
 */
public class ScatterAndGather {

    /**
     * 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。
     * 因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。
     * */

    /**
     * 聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，
     * 因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。
     * */
    public static void gather(String filePath){
        ByteBuffer header = ByteBuffer.allocate(1024);
        ByteBuffer body = ByteBuffer.allocate(1024);

        header.put("hello world!".getBytes());
        body.put("hello sfc!".getBytes());
        //filp不能少，否则无法从buffs中读取数据
        header.flip();
        body.flip();

        ByteBuffer[] buffs = {header,body};
        FileChannel channel = null;
        try {

            FileOutputStream os = new FileOutputStream(filePath);
            channel = os.getChannel();
            //这里是直接发送ByteBuffer数据
            channel.write(buffs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
