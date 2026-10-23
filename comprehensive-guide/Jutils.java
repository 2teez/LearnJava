package com.practice.jutils;

import static java.lang.System.out;

public class Jutils {

    public static class utils {

        @SafeVarargs
        public static <T> void prints(String msg, T... args) {
            var sb = new StringBuilder();

            if (!msg.isBlank()) {
                sb.append(msg);
            }
            for (var ind = 0; ind < args.length; ++ind) {
                if (ind > 0) {
                    sb.append(", ");
                }
                sb.append(args[ind]);
            }
            out.println(sb);
        }

        @SafeVarargs
        public static <T> void prints(T... args) {
            prints("", args);
        }

        public static double sum(double[] values) {
            double total = 0;
            for (var value : values) {
                total += value;
            }
            return total;
        }
    }
}
