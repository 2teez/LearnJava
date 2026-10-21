package com.practice.jutils;

import static java.lang.System.out;

import java.util.Arrays;

public class Jutils {

    public static void prints(String msg, Object[] args) {
        out.print(msg);
        out.println(Arrays.toString(args));
    }
}
