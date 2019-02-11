package com.codecool.taxi;

public abstract class Car {
    protected int id;
    protected int capacity;
    protected int cost;
    protected static int counter = 0;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    protected Car(int capacity, int cost) {
        this.id = ++counter;
        this.capacity = capacity;
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCost() {
        return cost;
    }


}
