package com.sfc.multithread;

import com.sfc.designpattern.singleton.SingletonLazy;

/**
 * Java中线程的创建常见有如三种基本形式
 * 1.继承Thread类，重写该类的run()方法。
 * Created by Prophet on 2017/2/12.
 */
public class MyThread extends Thread {

    private int i = 0;
    boolean a = true;
    int j = 1;

    @Override
    public void run() {
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            test();
            SingletonLazy.getInstance().getThreadName();
        }
    }

    private synchronized void test(){

    }
}
