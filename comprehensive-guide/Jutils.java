package com.practice.jutils;

import static java.lang.System.out;

import java.util.Arrays;

public class Jutils {

    public static <T extends Object> void prints(String msg, T[] args) {
        out.print(msg);
        out.println(Arrays.toString(args));
    }
}
