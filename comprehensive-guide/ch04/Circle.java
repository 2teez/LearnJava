package com.practice.circle;

import com.practice.shape.Shape;
import com.practice.shaper.Shaper;

public class Circle extends Shape implement Shaper {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}
