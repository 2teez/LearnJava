package com.practice.twodshape;

public abstract class TwoDShape {

    private double width;
    private double height;
    private String name;

    public TwoDShape(double width, double height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public abstract double area();

    public String getName() {
        return name;
    }
}
