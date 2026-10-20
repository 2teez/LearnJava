package com.practice.innerclass;

import static java.lang.System.out;

public class Innerclass {

    public static void main(String[] args) {
        out.println(FriendlyGreeter.greeter());
    }

    static class FriendlyGreeter {

        static String greeter() {
            return "Hey!!";
        }
    }
}
