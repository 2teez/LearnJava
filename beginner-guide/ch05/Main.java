package com.practice.main;

import com.practice.circle.Circle;

public class Main {

    public static void main(String[] args) {
        var circle = new Circle(5.0, "Circle");
        System.out.println(circle.area());
    }
}
