package com.practice.app;

import static java.lang.System.out;

import java.util.Scanner;

public class ValidatorMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var input = getUserInput("Enter a pass: ");
        var validator = getUserInput("Enter a validator: ");
        var password = new Validator(input);
        var access = password.validate(validator);
        if (access) out.println(password.getPassword());
    }

    public static String getUserInput(String str) {
        System.out.print(str);
        var input = scanner.nextLine();
        return input.trim();
    }
}
