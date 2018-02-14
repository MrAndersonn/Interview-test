package com.globallogic.test.cmd;

import com.globallogic.test.cmd.command.*;
import com.globallogic.test.cmd.helper.ConsoleHelper;

import java.io.IOException;
import java.util.HashMap;

public class CommandListener {
    private static HashMap<String,Command> commands= new HashMap<>();
    static {
        commands.put("--calc tc", new TotalAirLineCapacityCommand());
        commands.put("--calc cc",  new CarryingAirLineCapacityCommand());
        commands.put("--lsfr", new SortingAircraftByFlightRangeCommand());
        commands.put("--sfc", new FindAirCraftByFuelConsumptionCommand());
        commands.put("--help", new HelpCommand());
    }
    public void launch() {
        String command;
        try {
            while (!(command = ConsoleHelper.readOneLineFromConsole().trim()).equals("exit")) {
                Command commandForExecute= commands.get(command);
                if (commandForExecute!=null){
                    commandForExecute.execute();
                }else {
                    ConsoleHelper.println("Please input valid command");
                    commands.get("--help").execute();
                }
            }
        } catch (IOException e) {
            System.out.println("Some trouble with I/O");
        }
    }
}
/* --calc tc - calc total capacity
 * --calc cc - calc carrying capacity
 * --lsfr  - list of company by flight range
 * --sfc - search by fuel consumption
 * */