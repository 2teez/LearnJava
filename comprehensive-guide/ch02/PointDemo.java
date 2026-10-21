package com.practice.pointdemo;

import static java.lang.System.out;

class PointDemo {

    public static void main(String[] args) {
        final var pt1 = new Point(2, 5);
        final var pt2 = new Point(2, 5);
        out.println(pt1 == pt2);
        out.println(pt1.equals(pt2));
    }
}

record Point(int x, int y) {}
