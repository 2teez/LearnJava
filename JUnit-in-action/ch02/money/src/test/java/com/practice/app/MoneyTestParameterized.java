package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTestParameterized {

    private final String VALID_CURRENCY = "NAR";

    @ParameterizedTest
    @ValueSource(ints = { 10, 15, 20 })
    @DisplayName("construction should set amount with provided parameterized.")
    public void constructionShouldSetAmount(int amount) {
        var money = new Money(amount, VALID_CURRENCY);
        assertThat(money.amount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource({ "10, USD", "134, NAR", "15, EUR" })
    @DisplayName(
        "constructor should set amount and currency with provided parameterized."
    )
    public void constructionShouldSetAmountAndCurreny(
        int amount,
        String currency
    ) {
        var money = new Money(amount, currency);
        assertThat(money.amount()).isEqualTo(amount);
        assertThat(money.currency()).isEqualTo(currency);
    }

    @ParameterizedTest
    @ValueSource(ints = { -23, -34789, -7 })
    @DisplayName(
        "constructor should throw IllegalArgumentException if invalid parameter is used."
    )
    public void constructionShouldThrowIAEIfInvalidValueAreUsed(
        int inValidAmount
    ) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> {
                new Money(inValidAmount, VALID_CURRENCY);
            }
        );
    }
}
