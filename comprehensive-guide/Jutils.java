package com.practice.jutils;

import static java.lang.System.out;

import java.util.Arrays;

public class Jutils {

    public static class utils {

        public static <T> void prints(String msg, T[] args) {
            out.print(msg.isBlank() ? "" : msg);
            out.println(Arrays.toString(args));
        }

        public static <T> void prints(T[] args) {
            prints("", args);
        }
    }
}
