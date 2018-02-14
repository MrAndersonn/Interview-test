package com.globallogic.test.cmd.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    public static String readOneLineFromConsole() throws IOException {
        System.out.println("Please enter command, or 'exit' for end session.");
        return CONSOLE_READER.readLine();
    }

    public static String readOneLineFromConsole(String description) throws IOException {
        System.out.println(description+", or 'exit' for returning to command menu.");
        return CONSOLE_READER.readLine();
    }

    public static void println(String massage){
        System.out.println(massage);
    }

}
