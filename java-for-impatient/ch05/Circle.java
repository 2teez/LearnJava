package com.practice.circle;

import com.practice.point.Point;
import com.practice.shape.Shape;

public class Circle extends Shape {

    private double radius;

    public Circle(Point p, double radius) {
        super(p);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        Point p = getPoint();
        return new Point(
            Math.sqrt(p.getX() * this.radius),
            Math.sqrt(p.getY() * this.radius)
        );
    }

    @Override
    public String toString() {
        return String.format("In Circle");
    }
}
