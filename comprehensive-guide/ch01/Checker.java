package com.practice.checker;

import static java.lang.System.out;

class Checker {

    public static void main(String[] args) {
        out.println("Start Here");
        final var eeta = new Number(3);
        out.println(eeta.isEven());
    }
}

class Number {

    private int value;

    Number(int value) {
        this.value = value;
    }

    public boolean isEven() {
        return this.value % 2 == 0;
    }

    public boolean isOdd() {
        return !this.isEven();
    }

    @Override
    public String toString() {
        return String.join(",", this.value + " ");
    }
}
