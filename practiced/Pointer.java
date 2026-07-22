package com.practice.pointer;

import static java.lang.System.out;

class Pointer {

    public static void main(String[] args) {
        var p = new Point(3, 4);
        out.println(p);
        Point pt = new Point(3, 4).translate(1, 3).scale(0.5);
        out.println(pt);
        // using POJ
        var pt2 = new PointCl(3, 4).translate(1, 3).scale(0.5);
        out.println(pt2);
    }
}

record Point(double x, double y) {
    Point translate(int xValue, int yValue) {
        return new Point(x + xValue, y + yValue);
    }

    Point scale(double value) {
        return new Point(x * value, y * value);
    }
}

class PointCl {
    private double x;
    private double y;

    PointCl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    PointCl translate(int xValue, int yValue) {
        this.x += xValue;
        this.y += yValue;
        return this;
    }

    PointCl scale(double value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    @Override
    public String toString() {
        return String.format("PointCl(x=%.1f,y=%.1f)", this.x, this.y);
    }
}
