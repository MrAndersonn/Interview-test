package com.globallogic.test.cmd.command;

import com.globallogic.test.cmd.helper.ConsoleHelper;
import com.globallogic.test.model.AirCraft;
import com.globallogic.test.model.AirLineCompany;
import com.globallogic.test.model.Company;
import com.globallogic.test.service.AirlineService;
import com.globallogic.test.service.ServicesInit;
import com.globallogic.test.service.action.Sorting;
import com.globallogic.test.service.actionImpl.SortingAirCraftByFlightRange;

import java.io.IOException;
import java.util.List;

public class SortingAircraftByFlightRangeCommand implements Command {
    private AirlineService airlineService = ServicesInit.getAirlineService();

    private Sorting<AirCraft> sorting = new SortingAirCraftByFlightRange();

    @Override
    public void execute() throws IOException {
        List<AirLineCompany> allCompany = airlineService.getAllAirCraftCompany();
        for (int i = 0; i < allCompany.size(); i++) {
            Company company = allCompany.get(i);
            ConsoleHelper.println(i + ". " + company);
        }

        String indexOfCompany;
        while (!(indexOfCompany = ConsoleHelper.readOneLineFromConsole("Please select company")).equals("exit")) {
            int index = Integer.parseInt(indexOfCompany);
            if (index >= 0 && index < allCompany.size()) {
                System.out.println(
                        sorting.sort(allCompany.get(index).getTransports())
                );
                break;
            } else ConsoleHelper.println("Please insert valid index of Company");
        }
    }
}
