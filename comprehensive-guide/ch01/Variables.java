package com.practice.variables;

import static java.lang.System.err;
import static java.lang.System.out;

import java.io.IOException;
import java.util.Scanner;

public class Variables {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        out.println("Start Here");
        final var name = getUserInput("Enter your name: ");
        int age = 0;
        try {
            age = Integer.parseInt(getUserInput("Enter your age: "));
        } catch (NumberFormatException nfex) {
            err.println(nfex.getMessage());
        }
        out.println("My name is " + name + ", I am " + age + " years old!");
        scanner.close();
    }

    static String getUserInput(String msg) {
        out.print(msg);
        String output = scanner.nextLine();
        while (output.isBlank()) {
            out.println("Can't use empty line..");
            out.print(msg);
            output = scanner.nextLine();
        }

        return output;
    }
}
