package com.codecool.taxi;

public class GasolineCar extends CarWithDriver {
    private int maintenanceCost;
    private static int maintenanceGrowth;
    private static final int cost = 350;

    public GasolineCar(Driver driver) {
        super(driver, cost);
        this.maintenanceCost = 20;
        maintenanceGrowth = (int) (maintenanceCost * 0.1);
    }

    public int getMaintenanceCost() {
        return maintenanceCost;
    }

    public Driver getDriver() {
        return driver;
    }

    public void increaseMaintenanceCost() {
        maintenanceCost += maintenanceGrowth;
        // maintenanceGrowth = (int) (maintenanceCost * 0.1);
    }
}
