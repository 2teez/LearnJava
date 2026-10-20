package com.practice.innerclass;

import static java.lang.System.out;

public class Innerclass {

    public static void main(String[] args) {
        out.println(FriendlyGreeter.greeter());
        AnotherFriendlyGreeter.greeter();
        //
        out.println(Innerclass.myGreet());
    }

    static String myGreet() {
        class MethodInnerClass {

            String greet() {
                return "Howdy...";
            }
        }
        return new MethodInnerClass().greet();
    }

    static class FriendlyGreeter {

        static String greeter() {
            return "Hey!!";
        }
    }

    class AnotherFriendlyGreeter {

        static void greeter() {
            out.println("Hello...");
        }
    }
}
