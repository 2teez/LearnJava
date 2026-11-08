package com.practice.calculatortest;

import com.practice.calculator.Calculator;

public class CalculatorTest {

    public static void main(String[] args) {
        var calculator = new Calculator();
        var result = calculator.add(0.3, 7.34);
        System.out.println(result);
    }
}
