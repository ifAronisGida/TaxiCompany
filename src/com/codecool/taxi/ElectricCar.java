package com.codecool.taxi;

public class ElectricCar extends CarWithDriver {

    private static final int cost = 400;

    protected ElectricCar(Driver driver) {
        super(driver, cost);
    }
}
