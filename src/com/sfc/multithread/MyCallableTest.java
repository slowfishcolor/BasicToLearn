package com.sfc.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Prophet on 2017/2/13.
 */
public class MyCallableTest {
    public static void main(String[] args) {
        // 创建Callable对象
        Callable<Integer> myCallable = new MyCallable();
        // 使用FutureTask来包装MyCallable对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 3) {
                // FutureTask对象作为Thread对象的target创建新的线程
                Thread thread = new Thread(futureTask);
                // 线程进入到就绪状态
                thread.start();
            }
        }

        System.out.println("主线程for循环执行完毕..");

        try {
            // 取得新创建的新线程中的call()方法返回的结果
            int sum = futureTask.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
