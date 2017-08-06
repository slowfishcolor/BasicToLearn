package com.sfc.multithread;

/**
 * Created by Prophet on 2017/2/13.
 */
public class B {
    public void m() {
        A a = new A();
        a.a = 1;

    }
    public static void n() {
        A a = new A();
        a.a = 1;
        MyThread t = new MyThread();
        t.j = 1;
        Thread t2 = new Thread2();

    }

    public static void main(String[] args) {
        A a = new A();
        a.a = 1;
    }


}
