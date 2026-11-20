package com.practice.app;

public class Strings {

    public static void main(String[] args) {
        reverse("Howdy...");
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
