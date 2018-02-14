package com.globallogic.test.model;

import java.util.List;

public class AirLineCompany extends Company<AirCraft> {

    public AirLineCompany(List<AirCraft> transports) {
        super(transports);
    }

    public AirLineCompany(String name, List<AirCraft> transports) {
        super(name, transports);
    }
}
