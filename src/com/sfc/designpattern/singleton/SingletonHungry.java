package com.sfc.designpattern.singleton;

/**
 * Created by Prophet on 2017/2/17.
 */
public class SingletonHungry {

    private static final SingletonHungry singleton = new SingletonHungry();

    private void SingletonHungry() {

    }

    public static SingletonHungry getInstance() {
        return singleton;
    }

    // 其他方法，尽量是static的
    public static void doSomething() {

    }
}
