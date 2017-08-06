package com.sfc.designpattern.abstractfactory;

/**
 * 抽象工厂
 * 工厂方法模式： 一个抽象产品类，可以派生出多个具体产品类。
 * 一个抽象工厂类，可以派生出多个具体工厂类。
 * 每个具体工厂类只能创建一个具体产品类的实例。
 * 抽象工厂模式： 多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。
 * 一个抽象工厂类，可以派生出多个具体工厂类。
 * 每个具体工厂类可以创建多个具体产品类的实例，也就是创建的是一个产品线下的多个产品。
 * 简单工厂 ： 用来生产同一等级结构中的任意产品。（对于增加新的产品，无能为力）
 * 工厂方法 ：用来生产同一等级结构中的固定产品。（支持增加任意产品）
 * 抽象工厂 ：用来生产不同产品族的全部产品。（对于增加新的产品，无能为力；支持增加产品族）
 * 增加产品要修改Factory接口
 * Created by Prophet on 2017/2/14.
 */
public class Client {
    public static void main(String[] args) {

        CarFactory benzFactory = new CarFactoryBenz();
        CarFactory BMWFactory = new CarFactoryBMW();

        CarA benzA = benzFactory.buildCarA();
        CarA bmwA = BMWFactory.buildCarA();
        CarB benzB = benzFactory.buildCarB();
        CarB bmwB = BMWFactory.buildCarB();

        benzA.drive();
        benzB.drive();
        bmwA.drive();
        bmwB.drive();
    }
}
