package com.sfc.designpattern.abstractfactory;

/**
 * Created by Prophet on 2017/2/14.
 */
public class CarFactoryBenz implements CarFactory {
    @Override
    public CarA buildCarA() {
        return new CarABenz();
    }

    @Override
    public CarB buildCarB() {
        return new CarBBenze();
    }
}
