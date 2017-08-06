package com.sfc.designpattern.factory;

/**
 * Created by Prophet on 2017/2/14.
 */
public class CarAFactory implements CarFactory {
    @Override
    public Car buildCar() {
        return new CarA();
    }
}
