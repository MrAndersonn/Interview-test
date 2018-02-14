package com.globallogic.test.model;

public class AirCraft extends Transport implements Transferring {

    private long flightRange;

    public AirCraft(int capacity, float fuelConsumption, long flightRange) {
        super(capacity, fuelConsumption);
        this.flightRange = flightRange;
    }

    public AirCraft(int capacity, int carryingCapacity, float fuelConsumption, long flightRange) {
        super(capacity, carryingCapacity, fuelConsumption);
        this.flightRange = flightRange;
    }

    public void transfer() {
        //DO air transferring realisation
    }

    public long getFlightRange() {
        return flightRange;
    }

    @Override
    public String toString() {
        return "AirCraft{" +
                "flightRange=" + flightRange +
                '}';
    }


}
