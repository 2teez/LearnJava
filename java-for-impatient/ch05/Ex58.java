package com.practice.ex58;

enum Colours {
    BLACK(false, false, false),
    WHITE(true, true, true),
    RED(true, false, false),
    BLUE(false, false, true),
    GREEN(false, true, false),
    YELLOW(true, true, false),
    CYAN(false, true, true),
    MAGENTA(true, false, true);

    private final boolean red;
    private final boolean green;
    private final boolean blue;

    private Colours(boolean red, boolean green, boolean blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public boolean getRed() {
        return red;
    }

    public boolean getGreen() {
        return green;
    }

    public boolean getBlue() {
        return blue;
    }
}

public class Ex58 {

    public static void main(String[] args) {
        var colour = Colours.RED;
        System.out.println(colour.getRed());
    }
}
