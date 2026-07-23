package com.practice.ex51;

import static java.lang.System.out;

import com.practice.circle.Circle;
import com.practice.point.Point;
import com.practice.shape.Shape;

public class Ex51 {

    public static void main(String[] args) {
        Point p = new Point(120, 80);
        out.println(p);
        Circle circle = new Circle(p, 20);
        circle.moveBy(1, 0);
        System.out.println(circle.getCenter());
    }
}
