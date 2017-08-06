package com.sfc.multithread;

/**
 * Created by Prophet on 2017/2/12.
 */
public class MyThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 打印当前Thread
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 5) {

                // 创建新线程，进入新建状态(new)
                Thread myThread1 = new MyThread();
                Thread myThread2 = new MyThread();
                // 调用 start()方法，进入就绪状态
                myThread1.start();
                myThread2.start();

            }
        }
        Thread myThread1 = new MyThread();
        // 调用 start()方法，进入就绪状态
        Thread t = new Thread2();
//        myThread1.j;
    }
}
