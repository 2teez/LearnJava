package com.practice.pointer;

import static java.lang.System.out;

class Pointer {

    public static void main(String[] args) {
        var p = new Point(3, 4);
        out.println(p);
        Point pt = new Point(3, 4).translate(1, 3).scale(0.5);
        out.println(pt);
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
