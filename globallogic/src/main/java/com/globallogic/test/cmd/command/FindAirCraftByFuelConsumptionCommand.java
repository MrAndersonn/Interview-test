package com.globallogic.test.cmd.command;

import com.globallogic.test.cmd.helper.ConsoleHelper;
import com.globallogic.test.model.AirCraft;
import com.globallogic.test.service.AirlineService;
import com.globallogic.test.service.ServicesInit;
import com.globallogic.test.service.actionImpl.SearchingAirCraftByFuelConsumption;

import java.io.IOException;
import java.util.List;

public class FindAirCraftByFuelConsumptionCommand implements Command {
    private AirlineService airlineService = ServicesInit.getAirlineService();

    @Override
    public void execute() throws IOException {
        String range =
                ConsoleHelper.
                        readOneLineFromConsole(
                                "Please enter range of fuel Consumption in format : 'min-max'"
                        );
        float min = Float.parseFloat(range.split("-")[0]);
        float max = Float.parseFloat(range.split("-")[0]);

        List<AirCraft> airCrafts =
                new SearchingAirCraftByFuelConsumption(min, max)
                        .find(
                                airlineService.getAllAirCraftOnAirLine()
                        );
        if (airCrafts.size()==0)
            ConsoleHelper.println("Could`n find any Aircraft");
        else {
            for (int i = 0; i < airCrafts.size(); i++) {
                ConsoleHelper.println(i+". "+airCrafts.get(i));
            }
        }

    }
}
