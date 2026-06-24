package com.practice.primenumbers;

import static java.lang.System.out;

import java.io.Console;
import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {
        out.println("Start Here");
        var userInput = new UserInput();
        int number = userInput.getNumber();
        boolean result = isPrime(number);
        out.println("Is " + number + " a prime number? " + result);

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
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static class UserInput {

        private int getNumber() {
            var scanner = new Scanner(System.in);
            out.print("Enter a number: ");
            return scanner.nextInt();
        }
    }
}
