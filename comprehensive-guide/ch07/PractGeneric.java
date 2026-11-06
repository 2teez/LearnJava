package com.practice.practgeneric;

import java.util.ArrayList;

class PractGeneric {

    public static void main(String[] args) {
        System.out.println("Start Here");
    }
}

class Stack<T> {

    private ArrayList values;

    public Stack() {
        values = new ArrayList<T>();
    }

    public Stack<T> push(T value) {
        values.add(value);
        return this;
    }
}
