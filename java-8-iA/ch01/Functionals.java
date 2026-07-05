package com.practice.functionals;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Functionals {

    public static void main(String[] args) {
        Fruit[] apples = {
            new Fruit("Granny Smith", 100, "green"),
            new Fruit("Pink Lady", 150, "pink"),
            new Fruit("Red Delicious", 200, "red"),
            new Fruit("Red Ninja", 250, "red"),
        };

        filterFruits(apples, Fruit::isRedFruit).forEach(System.out::println);
    }

    public static Collection<Fruit> filterFruits(
        Fruit[] apples,
        Predicate<Fruit> predicate
    ) {
        return Arrays.stream(apples)
            .filter(predicate)
            .collect(Collectors.toList());
    }
}

record Fruit(String name, int weight, String color) {
    static boolean isRedFruit(Fruit fruit) {
        return fruit.color.equals("red");
    }
}
