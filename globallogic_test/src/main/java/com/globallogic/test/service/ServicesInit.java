package com.globallogic.test.service;

public class ServicesInit {
    private static AirlineService airlineService = new AirlineService();

    public static AirlineService getAirlineService() {
        return airlineService;
    }
}
