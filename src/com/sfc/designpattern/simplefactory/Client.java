package com.sfc.designpattern.simplefactory;

/**
 * 工厂模式适合：凡是出现了大量的产品需要创建，
 * 并且具有共同的接口时，可以通过工厂方法模式进行创建。
 * Created by Prophet on 2017/2/14.
 */
public class Client {
    public static void main(String[] args) {
        Car car1 = CarFactory.buildCarA();
        Car car2 = CarFactory.buildCarB();
        car1.drive();
        car2.drive();
    }
}
