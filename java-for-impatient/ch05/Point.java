package com.practice.point;

public class Point {

    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point pt = (Point) o;
        return pt.x == this.x && pt.y == this.y;
    }

    @Override
    public int hashCode() {
        return (int) (31 * (getX() + getX()));
    }

    @Override
    public String toString() {
        return String.format("Point(x=%.1f, y=%.1f)", this.x, this.y);
    }
}
