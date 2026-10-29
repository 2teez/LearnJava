package com.practice.rectangle;

import com.practice.shape.Shape;

public class Rectangle extends Shape {

    private double width;
    private double breath;

    public Rectangle(double width, double breath) {
        this.width = width;
        this.breath = breath;
    }

    @Override
    public double area() {
        return this.width * this.breath;
    }

    @Override
    public double perimeter() {
        return 2.0 * (this.width * this.breath);
    }

    @Override
    public String toString() {
        return String.format(
            "%s(%.2f, %.2f)",
            super.toString(),
            this.width,
            this.breath
        );
    }
}
