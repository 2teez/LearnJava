package com.practice.directionenum;

import static java.lang.System.out;

enum Direction {
    NORTH("North", 0),
    SOUTH("South", 1),
    EAST("East", 2),
    WEST("West", 3);

    private final String name;
    private final int index;

    private Direction(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getDirection() {
        return name;
    }

    public int getIndex() {
        return index + 1;
    }
}

public class DirectionEnum {

    public static void main(String[] args) {
        var direction = Direction.NORTH;
        out.println(
            switch (direction) {
                case NORTH -> "North";
                case SOUTH -> "South";
                case EAST -> "East";
                case WEST -> "West";
                default -> throw new IllegalStateException(
                    "Unexpected value: " + direction
                );
            }
        );
        out.println(direction.getIndex());
    }
}
