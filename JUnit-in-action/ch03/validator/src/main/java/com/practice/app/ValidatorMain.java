package com.practice.app;

import com.practice.app.Validator;
import java.util.Scanner;

public class ValidatorMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var input = getUserInput("Enter a pass: ");
        System.out.println(new Validator(input).getPassword());
    }

    public static String getUserInput(String str) {
        System.out.print(str);
        var input = scanner.nextLine();
        return input.trim();
    }
}
