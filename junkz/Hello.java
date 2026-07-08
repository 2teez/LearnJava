package com.practice.hello;

import java.util.function.Function;

@FunctionalInterface
interface Ariths {
    int apply(int a, int b);
}

@FunctionalInterface
interface Displayer {
    void display(String message, Runnable r);
}

public class Hello {

    public static void main(String[] args) {
        int result = Arithmetic.add(5, 3);
        System.out.println(result);
        //
        // using functional interface with method reference
        System.out.println(addition(5, 3, Arithmetic::add));

        // using functional interface with anonymous class
        new Displayer(){
            @Override
            public void display(String message, Runnable r) {
                System.out.println(message);
                r.run();
            }
        }.display("Show Addition:", () -> System.out.println(addition(5, 3, Arithmetic::add)));
        //
        // using functional interface with lambda expression
        Arithmetic.displayResult("Show Division:", Arithmetic::divide, new int[]{10, 2});
    }

    static int addition(int a, int b, Ariths f) {
        return f.apply(a, b);
    }

    static class Arithmetic {
        static int add(int a, int b) {
            return a + b;
        }

        static int subtract(int a, int b) {
            return a - b;
        }

        static int multiply(int a, int b) {
            return a * b;
        }

        static int divide(int a, int b) throws ArithmeticException {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }

        static void displayResult(String msg, Ariths f, int... values) {
            System.out.println(msg);
            System.out.println(f.apply(values[0], values[1]));
        }
    }
}
