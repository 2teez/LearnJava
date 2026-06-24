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
    }

    static double converGallonToLiter(int value) {
        double gallonStandard = 3.7854;
        return value * gallonStandard;
    }
}
