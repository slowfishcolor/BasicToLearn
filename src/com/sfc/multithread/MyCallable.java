package com.sfc.multithread;

import java.util.concurrent.Callable;

/**
 * Created by Prophet on 2017/2/13.
 */
public class MyCallable implements Callable<Integer> {

    private int i = 0;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {

        int sum = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }

        return sum;
    }
}
