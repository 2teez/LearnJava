package com.practice.circle;

import com.practice.twodshape.TwoDShape;

public class Circle extends TwoDShape {

    private double radius;

    public Circle(double radius, String name) {
        super(radius, radius, name);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
