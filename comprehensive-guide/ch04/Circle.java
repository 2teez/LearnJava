package com.practice.circle;

import com.practice.shape.Shape;
import com.practice.shaper.Shaper;

public class Circle extends Shape implements Shaper {

    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public double perimeter() {
        return 2.0 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
