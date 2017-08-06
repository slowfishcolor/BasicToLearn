package com.sfc.designpattern.factory;

/**
 * 工厂方法模式
 * 若要增加功能，则去做一个产品和工厂的实现类
 * 而不用像简单工厂那样去修改工厂的代码
 * 对修改关闭，对拓展开放
 * Created by Prophet on 2017/2/14.
 */
public class Client {
    public static void main(String[] args) {
        CarFactory factoryA = new CarAFactory();
        CarFactory factoryB = new CarBFactory();
        Car carA = factoryA.buildCar();
        Car carB = factoryB.buildCar();
        carA.drive();
        carB.drive();
    }
}
