package com.sfc.designpattern.factory;

/**
 * Created by Prophet on 2017/2/14.
 */
public class CarBFactory implements CarFactory {
    @Override
    public Car buildCar() {
        return new CarB();
    }
}
