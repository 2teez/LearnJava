package com.practice.app;

public class Strings {

    public static void main(String[] args) {
        reverse("Howdy...");
    }

    public static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("can't reverse empty string.");
        }
        return new StringBuilder(str).reverse().toString();
    }
}
