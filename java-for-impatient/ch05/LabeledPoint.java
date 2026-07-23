package com.practice.labeledpoint;

import com.practice.point.Point;

public class LabeledPoint extends Point {

    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
