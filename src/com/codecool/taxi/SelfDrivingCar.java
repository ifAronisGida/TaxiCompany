package com.codecool.taxi;

public class SelfDrivingCar extends Car {

    private static final int cost = 740;
    private static final int selfDrivingCapacity = 70;

    protected SelfDrivingCar() {
        super(selfDrivingCapacity, cost);
    }

    public void sendToMaintenance() {
        this.capacity = 0;
    }

    public void getBackFromMaintenance() {
        this.capacity = selfDrivingCapacity;
    }
}
