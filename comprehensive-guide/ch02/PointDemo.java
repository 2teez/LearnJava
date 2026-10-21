package com.practice.pointdemo;

import static java.lang.System.out;

class PointDemo {

    public static void main(String[] args) {
        final var pt1 = new Point(2, 5);
        final var pt2 = new Point(2, 5);
        out.println(pt1 == pt2);
        out.println(pt1.equals(pt2));
        //
        final var pt3 = new com.practice.point.Point(3, 6);
        final var pt4 = new com.practice.point.Point(3, 6);
        out.println(pt3 == pt4);
        out.println(pt3.equals(pt4));
        //
        out.println(p4);
    }
}

record Point(int x, int y) {}
