package com.practice.app;

public record Money(int amount, String currency) {
    public Money {
        if (amount < 0) {
            throw new IllegalArgumentException(
                String.format("Invalid amount [%d] provided.", amount)
            );
        }
    }
}
