package com.practice.circle;

public class Circle extends TwoDShape {

    private double radius;

    public Circle(double radius, String name) {
        super(radius, radius, name);
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
