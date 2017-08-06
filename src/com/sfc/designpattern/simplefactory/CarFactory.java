package com.sfc.designpattern.simplefactory;

/**
 * Created by Prophet on 2017/2/14.
 */
public class CarFactory {
    public static Car buildCarA() {
        return new CarA();
    }
    public static Car buildCarB() {
        return new CarB();
    }
}
