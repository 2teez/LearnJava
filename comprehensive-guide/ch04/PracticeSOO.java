package com.practice.practicesoo;

import static java.lang.System.out;

import com.practice.circle.Circle;
import com.practice.rectangle.Rectangle;
import com.practice.shape.Shape;
import com.practice.shaper.Shaper;
import com.practice.square.Square;
import java.util.Arrays;

class PracticeSOO {

    public static void main(String[] args) {
        final var shapes = Arrays.asList(new Shape[] {
            new Square(2.3),
            new Rectangle(1.15, 3.21),
            new Circle(1.25),
        });

        shapes.forEach(out::println);
        //
        // circle
        Shaper circle = new Circle(1.25);
        out.println(circle);
        out.println(circle.printProperties());
    }
}
