package com.sfc.multithread;

/**
 * 两个Thread共享了一个Runnble，从而共享了数据
 * Created by Prophet on 2017/2/12.
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 2) {
                // 创建一个Runnable实现类的对象
                Runnable myRunnable = new MyRunnable();
                // 将myRunnable作为Thread target创建新的线程
                Thread thread1 = new Thread(myRunnable);
                Thread thread2 = new Thread(myRunnable);
                // 调用start()方法使得线程进入就绪状态
                thread1.start();
                thread2.start();
            }
        }
    }
}
