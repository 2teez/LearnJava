package com.practice.shape;

public abstract class Shape {

    public abstract double area();

    public double perimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format(
            "%s: Area: %.2f, Perimeter: %.2f",
            this.getClass().getSimpleName(),
            this.area(),
            this.perimeter()
        );
    }
}
