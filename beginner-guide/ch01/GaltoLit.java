package com.practice.galtolit;

public class GaltoLit {

    public static void main(String[] args) {
        double gallons = 10;
        double gallonStandard = 3.7854;
        var liters = gallons * gallonStandard;
        System.out.printf("%.1f gallons is %.4f Liters.\n", gallons, liters);
        //
        // use a for loop
        for (var ind = 0; ind <= 100; ind++) {
            System.out.printf(
                "%.1f gallons is %.4f Liters.\n",
                (double) ind,
                converGallonToLiter(ind)
            );
            // an if statement
            if (ind % 10 == 0 && ind != 0) {
                System.out.println();
            }
        }
        // use a for loop
        for (var ind = 1; ind <= 12; ind++) {
            System.out.printf(
                "%.1f meters is %.4f inches.\n",
                (double) ind,
                new GaltoLit.Converter().convertMeterToInch(ind)
            );
        }
    }

    static double converGallonToLiter(int value) {
        double gallonStandard = 3.7854;
        return value * gallonStandard;
    }

    static class Converter {

        double convertMeterToInch(int value) {
            double inchStandard = 39.3701;
            return value * inchStandard;
        }
    }
}
