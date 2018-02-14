package com.globallogic.test.service.actionImpl;

import com.globallogic.test.model.AirCraft;
import com.globallogic.test.service.action.Sorting;

import java.util.List;

public class SortingAirCraftByFlightRange implements Sorting<AirCraft> {
    @Override
    public List<AirCraft> sort(List<AirCraft> entities) {
        entities.sort((o1, o2) -> (int) (o1.getFlightRange() - o2.getFlightRange()));
        return entities;
    }
}
