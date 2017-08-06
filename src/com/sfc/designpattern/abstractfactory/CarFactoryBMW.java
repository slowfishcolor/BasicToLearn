package com.sfc.designpattern.abstractfactory;

/**
 * Created by Prophet on 2017/2/14.
 */
public class CarFactoryBMW implements CarFactory {
    @Override
    public CarA buildCarA() {
        return new CarABMW();
    }

    @Override
    public CarB buildCarB() {
        return new CarBBMW();
    }
}
