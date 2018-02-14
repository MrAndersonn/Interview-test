package com.globallogic.test.service.actionImpl;

import com.globallogic.test.model.AirCraft;
import com.globallogic.test.service.AirlineService;
import com.globallogic.test.service.ServicesInit;
import com.globallogic.test.service.action.Searching;

import java.util.ArrayList;
import java.util.List;

public class SearchingAirCraftByFuelConsumption implements Searching<AirCraft> {

    private float min;
    private float max;

    public SearchingAirCraftByFuelConsumption(float min, float max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public List<AirCraft> find(List<AirCraft> airCrafts) {
        List<AirCraft> result = new ArrayList<>();
        for (AirCraft airCraft :
                airCrafts) {
            float fuelConsumption = airCraft.getFuelConsumption();
            if (fuelConsumption>=min&&fuelConsumption<=max)
                result.add(airCraft);
        }
        return result;
    }
}
