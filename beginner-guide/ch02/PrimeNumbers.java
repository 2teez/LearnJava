package com.practice.primenumbers;

import static java.lang.System.out;

import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumbers {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        out.println("Start Here");
        while (true) {
            try {
                var number = new UserInput().getNumber("Enter a number: ");
                boolean result = isPrime(number);
                out.println("Is " + number + " a prime number? " + result);
                break;
            } catch (InputMismatchException e) {
                out.println("Error reading input: " + e.getMessage());
                SCANNER.nextLine();
            }
        }

        Console console = System.console();
        if (console != null) {
            console.writer().println("Press Enter to exit...");
            console.readLine();
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        var limit = (int) Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static class UserInput {

        private int getNumber(String msg) {
            out.print(msg);
            return SCANNER.nextInt();
        }
    }
}
