package com.sfc.multithread;

/**
 * Created by Prophet on 2017/2/12.
 */
public class Thread2Test {
    public static void main(String[] args) {
        Thread2 t = new Thread2();
        t.start();
        try {
            Thread.sleep(10000); //主线程睡眠10秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //主线程睡眠10秒钟后结束t线程
        //t.interrupt(); //这种结束方式比较粗暴，如果t线程打开了某个资源还没来得及关闭也就是run方法还没有执行完就强制结束线程，会导致资源无法关闭
        //t.stop();也是结束某个线程，这种方式比interrupt()更粗暴
        t.flag = false;
    }
}
