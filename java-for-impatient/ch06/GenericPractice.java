package com.practice.genericpractice;

import java.util.Arrays;

public class GenericPractice {

    public static void main(String[] args) {
        Double[] result = GenericPractice.<Double>swap(0, 1, 1.5, 2.0, 3.5);
        System.out.println(Arrays.toString(result));
    }

    @SafeVarargs
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}
