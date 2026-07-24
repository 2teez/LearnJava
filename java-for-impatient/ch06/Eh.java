package com.practice.eh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Eh {

    private static final System.Logger logger = System.getLogger(
        Eh.class.getName()
    );

    public static void main(String[] args) {
        try {
            System.out.println(new Eh().sumOfValues("doubleFiles.txt"));
        } catch (IOException e) {
            logger.log(System.Logger.Level.ERROR, e.getMessage(), e);
        }
    }

    public double sumOfValues(String filename) throws IOException {
        ArrayList<Double> values = readValues(filename);
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    public ArrayList<Double> readValues(String filename) throws IOException {
        ArrayList<Double> values = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextDouble()) {
                values.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            throw new IOException("File not found: " + filename, e);
        } catch (NumberFormatException e) {
            throw new IOException(
                "Number format exception: " + e.getMessage(),
                e
            );
        }

        return values;
    }
}
