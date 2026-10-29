package com.practice.practicesoo;

import static java.lang.System.out;

import com.practice.rectangle.Rectangle;
import com.practice.shape.Shape;
import com.practice.square.Square;
import java.util.Arrays;

class PracticeSOO {

    public static void main(String[] args) {
        final var shapes = Arrays.asList(new Shape[] {
            new Square(2.3),
            new Rectangle(1.15, 3.21),
        });

        shapes.forEach(System.out::println);
        shapes.forEach(sh ->
            out.printf(
                "%s: Area: %.2f, Perimeter: %.2f\n",
                sh.getClass().getSimpleName(),
                sh.area(),
                sh.perimeter()
            )
        );
    }
}
