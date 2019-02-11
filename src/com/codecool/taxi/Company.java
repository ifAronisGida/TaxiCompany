package com.codecool.taxi;

import java.util.ArrayList;
import java.util.Random;

public class Company {
    private ArrayList<Car> allCar;
    private ArrayList<GasolineCar> gasolineCars;
    private ArrayList<SelfDrivingCar> selfDrivingCars;
    private ArrayList<Driver> allDriver;
    private int money;
    private int peopleTransported;


    protected Company() {

        money = 0;
        peopleTransported = 0;
        allCar = new ArrayList<>();
        gasolineCars = new ArrayList<>();
        selfDrivingCars = new ArrayList<>();
        allDriver = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            GasolineCar gasolineCar = new GasolineCar(new Driver());
            allCar.add(gasolineCar);
            gasolineCars.add(gasolineCar);
            allDriver.add(gasolineCar.getDriver());

            ElectricCar electricCar = new ElectricCar(new Driver());
            allCar.add(electricCar);
            allDriver.add(electricCar.getDriver());

            SelfDrivingCar selfDrivingCar = new SelfDrivingCar();
            allCar.add(selfDrivingCar);
            selfDrivingCars.add(selfDrivingCar);
        }
    }

    private void transportPeople() {
        for (Car car: allCar) {
            peopleTransported += car.getCapacity();
            money += car.getCapacity();
            System.out.println("Income: " + car.getCapacity());
        }
    }

    private void manageMaintenance() {
        for (GasolineCar car: gasolineCars) {
            money -= car.getMaintenanceCost();
            car.increaseMaintenanceCost();
            System.out.println("Expense: " + car.getMaintenanceCost());
        }
        for (SelfDrivingCar selfDrivingCar : selfDrivingCars) {
            selfDrivingCar.getBackFromMaintenance();
        }
    }

    private void tryToBuyCar() {
        Driver driver = new Driver();
        ElectricCar electricCar = new ElectricCar(driver);
        SelfDrivingCar selfDrivingCar = new SelfDrivingCar();
        Random random = new Random();
        if (random.nextDouble() <= 0.5) {

            if (selfDrivingCar.getCost() <= money) {
                allCar.add(selfDrivingCar);
                money -= selfDrivingCar.getCost();
                for (SelfDrivingCar selfDrivingCar1 : selfDrivingCars) {
                    selfDrivingCar1.sendToMaintenance();
                }
                selfDrivingCars.add(selfDrivingCar);
                System.out.println("BOUGHT NEW SELF DRIVING CAR !!");
            }
        } else {

            if ((electricCar.getCost() + driver.getSalary()) <= money) {
                money -= (electricCar.getCost() + driver.getSalary());
                allCar.add(electricCar);
                allDriver.add(driver);
                System.out.println("BOUGHT NEW ELECTRIC CAR AND HIRED A DRIVER AS WELL !!");
            }
        }
    }



    public void simulateOneWeek(){
        transportPeople();
        manageMaintenance();
        tryToBuyCar();
        System.out.println("money: " + money);
        System.out.println("passengers transported so far: " + peopleTransported);
    }
}
