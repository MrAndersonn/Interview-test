package com.globallogic.test.model;

public abstract class Transport {
    private int capacity;
    private int carryingCapacity;
    private float fuelConsumption;

    public Transport(int capacity, float fuelConsumption) {
        this.capacity = capacity;
        this.carryingCapacity = 0;
        this.fuelConsumption = fuelConsumption;
    }


    public Transport(int capacity, int carryingCapacity, float fuelConsumption) {
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public float getFuelConsumption() {
        return fuelConsumption;
    }


}
