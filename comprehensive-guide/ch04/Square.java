package com.practice.square;

import com.practice.rectangle.Rectangle;

public final class Square extends Rectangle {

    private double side;

    public Square(double side) {
        super(side, side);
    }
}
