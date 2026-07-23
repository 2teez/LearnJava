package com.practice.shape;

import com.practice.point.Point;

public abstract class Shape {

    private Point p;

    public Shape(Point p) {
        this.p = p;
    }

    protected Point getPoint() {
        return this.p;
    }

    public void moveBy(double dx, double dy) {
        p = new Point(p.getX() + dx, p.getY() + dy);
    }

    public abstract Point getCenter();
}
