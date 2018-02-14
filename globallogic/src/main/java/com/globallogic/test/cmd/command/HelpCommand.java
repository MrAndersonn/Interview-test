package com.globallogic.test.cmd.command;

import com.globallogic.test.cmd.helper.ConsoleHelper;

import java.io.IOException;

public class HelpCommand implements Command  {
    @Override
    public void execute() throws IOException {
        ConsoleHelper.println(
                "--calc tc - calc total capacity\n" +
                        "--calc cc - calc carrying capacity\n" +
                        "--lsfr  - list of company by flight range\n" +
                        "--sfc - search by fuel consumption"
        );
    }
}
