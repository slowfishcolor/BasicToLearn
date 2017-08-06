package com.sfc.designpattern.singleton;

/**
 * Created by Prophet on 2017/2/17.
 */
public class SingletonLazy {

    private static SingletonLazy singleton = null;

    private void SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (singleton == null) {
            synchronized (SingletonLazy.class) {
                if (singleton == null)
                    return new SingletonLazy();
            }
        }
        return singleton;
    }

    public void getThreadName() {
        System.out.println(Thread.currentThread().getName());
    }

}
