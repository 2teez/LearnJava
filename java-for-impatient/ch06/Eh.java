package com.practice.eh;

import static java.lang.System.Logger.Level.ERROR;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eh {

    private static final System.Logger logger = System.getLogger(
        Eh.class.getName()
    );

    public static void main(String[] args) {
        try {
            String input = getUserInput("Enter a filename: ");
            System.out.println(new Eh().sumOfValues(input));
        } catch (IllegalStateException | IOException e) {
            logger.log(ERROR, e.getMessage(), e);
        }
    }

    public static String getUserInput(String msg) throws IllegalStateException {
        System.out.print(msg);
        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("No console available");
        }
        return console.readLine();
    }

    public double sumOfValues(String filename) throws IOException {
        List<Double> values = readValues(filename);
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    public List<Double> readValues(String filename) throws IOException {
        List<Double> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextDouble()) {
                values.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File not found: " + filename, e);
        }

        return values;
    }
}
