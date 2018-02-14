package com.globallogic.test.cmd.command;

import com.globallogic.test.cmd.helper.ConsoleHelper;
import com.globallogic.test.service.AirlineService;
import com.globallogic.test.service.ServicesInit;

import java.io.IOException;

public class TotalAirLineCapacityCommand implements Command {

    private AirlineService airlineService = ServicesInit.getAirlineService();

    @Override
    public void execute() throws IOException {
        ConsoleHelper.println("Total capacity in the AirLine is : " + airlineService.calculateTotalCapacity());
    }
}
