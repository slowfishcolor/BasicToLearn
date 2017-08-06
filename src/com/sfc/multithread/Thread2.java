package com.sfc.multithread;

import java.util.Date;

/**
 * Created by Prophet on 2017/2/12.
 */
public class Thread2 extends  Thread{
    boolean flag = true; //用这种方式结束线程很不错，用一个变量控制run方法什么时候不再执行，不会出现run方法没有执行完毕就结束
    @Override
    public void run() { //run方法一结束，整个线程就终止了
        while(flag){
            System.out.println("---"+new Date()+"---");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
