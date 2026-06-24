package com.practice.example2;

import static java.lang.System.out;

public class Example2 {

    public static void main(String[] args) {
        var intVal = 1024;
        out.println("Int value: " + intVal);
        int intVal2 = intVal / 2;
        out.printf("%d / 2 = %d\n", intVal, intVal2);
    }
}
