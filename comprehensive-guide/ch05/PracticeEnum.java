package com.practice.practiceenum;

import static java.lang.System.out;

import java.util.Arrays;

class PracticeEnum {

    public static void main(String[] args) {
        Arrays.asList(Direction.values()).forEach(directions ->
            out.println(directions.named())
        );
        Arrays.asList(Direction.values()).forEach(directions ->
            out.println(directions.ordinal())
        );
    }
}

enum Direction {
    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");

    final String directionName;

    Direction(String directionName) {
        this.directionName = directionName;
    }

    public String named() {
        return this.name().toLowerCase();
    }
}
