package com.practice.stringsviews;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello..");
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
