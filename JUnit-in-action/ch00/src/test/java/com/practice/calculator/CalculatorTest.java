package com.practice.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        var result = Calculator.add(0.1, 0.2);
        assertEquals(0.3, result, 333333);
    }
}
