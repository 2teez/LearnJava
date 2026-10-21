package com.practice.point;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        final var o = (Point) obj;
        return o.x == this.x && o.y == this.y;
    }

    @Override
    public String toString() {
        return String.format("Point(x = %d, y = %d)", x, y);
    }
}
