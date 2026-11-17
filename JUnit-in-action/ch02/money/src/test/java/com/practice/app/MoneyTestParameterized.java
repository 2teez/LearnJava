package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTestParameterized {

    @ParameterizedTest
    @ValueSource(ints = { 10, 15, 20 })
    @DisplayName(
        "construction should set amount and currency with provided parameterized."
    )
    public void constructionShouldSetAmountAndCurreny(int amount) {
        var money = new Money(amount, "Naira");
        assertThat(money.amount()).isEqualTo(amount);
    }
}
