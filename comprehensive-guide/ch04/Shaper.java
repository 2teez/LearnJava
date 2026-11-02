package com.practice.shaper;

public interface Shaper {
    double area();
    double perimeter();

    default String toString() {
        String.format(
            "%s: Area: %.2f, Perimeter: %.2f",
            this.getClass().getSimpleName(),
            this.area(),
            this.perimeter()
        );
    }
}
