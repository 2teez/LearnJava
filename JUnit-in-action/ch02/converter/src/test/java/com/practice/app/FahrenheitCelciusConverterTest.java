package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FahrenheitCelciusConverterTest {

    @ParameterizedTest
    @CsvSource({ "0, 32", "37, 98", "100, 212" })
    @DisplayName("Should convert Celcius to Fahrenheit scale.")
    public void shouldConvertCelciusToFahrenheit(int celcius, int fahrenheit) {
        assertThat(FahrenheitCelciusConverter.toFahrenheit(celcius)).isEqualTo(
            fahrenheit
        );
    }

    @ParameterizedTest
    @CsvSource({ "0, 32", "36, 98", "100, 212" })
    @DisplayName("Should convert Fahrenheit to Celcius scale.")
    public void shouldConvertFahrenheitToCelcius(int celcius, int fahrenheit) {
        assertThat(FahrenheitCelciusConverter.toCelcius(fahrenheit)).isEqualTo(
            celcius
        );
    }
}
