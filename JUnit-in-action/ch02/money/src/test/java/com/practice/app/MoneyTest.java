package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    @DisplayName("construction should set amount and currency.")
    public void constructionSettingAmountAndCurrency() {
        var money = new Money(10, "Naira");
        var expectedAmount = 10;
        var expectedCurrency = "Naira";
        assertThat(money.amount()).isEqualTo(expectedAmount);
        assertEquals(expectedCurrency, money.currency());
    }
}
