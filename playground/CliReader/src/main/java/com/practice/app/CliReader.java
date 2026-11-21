package com.practice.app;

import static java.lang.System.out;

import java.io.Console;
import java.util.Scanner;

public class CliReader {

    //private static final Scanner scan = new Scanner(System.in);
    //private static final Console console = System.console();

    public static void main(String[] args) {
        var firstname = getUserInput("Enter your firstname: ");
        out.println(firstname);
        var lastname = inputFromConsole("Enter your lastname: ");
        out.println(lastname);
    }

    public static String getUserInput(String msg) {
        var scan = new Scanner(System.in);
        out.print(msg);
        var input = scan.nextLine();
        while (input == null || input.isEmpty()) {
            out.print(msg);
            input = scan.nextLine();
        }
        scan.close();
        return input.trim();
    }

    public static String inputFromConsole(String msg) {
        var console = System.console();
        out.print(msg);
        var input = console.readLine();
        while (input == null || input.isEmpty()) {
            out.print(msg);
            input = console.readLine();
        }
        return input.trim();
    }
}
