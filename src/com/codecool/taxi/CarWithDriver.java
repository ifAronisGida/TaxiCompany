package com.codecool.taxi;

public abstract class CarWithDriver extends Car{
    protected Driver driver;

    public CarWithDriver(Driver driver, int cost) {
        super(getCapacityByDriver(driver), cost);
        this.driver = driver;
    }

    protected Driver getDriver() {
        return driver;
    }
    protected static int getCapacityByDriver(Driver driver) {
        int capacity;
        Driver.Experience experience = driver.getExperience();
        switch (experience) {
            case ADVANCED:
                capacity = 25;
                break;
            case BEGINNER:
                capacity = 15;
                break;
            case PROFESSIONAL:
                capacity = 40;
                break;
            default:
                capacity = 15;
                break;
        }
        return capacity;
    }

}
