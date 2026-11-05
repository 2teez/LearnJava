package com.practice.practiceassertions;

public class PracticeAssertions {

    public static void main(String[] args) {
        var greet = "Hello";
        assert greet == "Hello" : "String equals checked";
        assert greet ==
            NestedClass.sayHello() : "Equal string from nested class";
    }

    class NestedClass {

        private static String sayHello() {
            return "Hello";
        }
    }
}
