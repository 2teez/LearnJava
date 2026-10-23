package com.practice.arrayprints;

import static com.practice.jutils.Jutils.utils;

import com.practice.jutils.Jutils.utils;

public class ArrayPrints {

    public static void main(String[] args) {
        final double[] costs = { 2, 7, 3 };
        utils.prints(utils.sum(costs) / costs.length);
        final String[] ws = { "World", "Wars", "Warriors" };
        utils.prints("Hello, ", ws);
    }
}
