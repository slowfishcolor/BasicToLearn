package com.sfc.multithread;

/**
 * 2.实现Runnable接口，并重写该接口的run()方法，该run()方法同样是线程执行体，
 * 创建Runnable实现类的实例，并以此实例作为Thread类的target来创建Thread对象，
 * 该Thread对象才是真正的线程对象。
 * Created by Prophet on 2017/2/12.
 */
public class MyRunnable implements Runnable{

    private int i = 0;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
