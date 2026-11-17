package com.practice.app;

/**
 * FahrenheitCelciusConverter
 */
public class FahrenheitCelciusConverter {

    /**
     * @param celsius
     * @return Fahrenheit in int
     */
    public static int toFahrenheit(int celsius) {
        return (celsius * 9) / 5 + 32;
    }

    /**
     * @param fahrenheit
     * @return Celcius in int
     */
    public static int toCelcius(int fahrenheit) {
        return ((fahrenheit - 32) * 5) / 9;
    }
}
