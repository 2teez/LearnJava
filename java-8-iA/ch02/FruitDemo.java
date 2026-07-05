package com.practice.fruitdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

enum Color {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
}

interface FruitPredicate {
    boolean test(Fruit fruit);
}

public class FruitDemo {

    public static void main(String[] args) {
        Fruit[] fruits = {
            new Fruit("Apple", 100, Color.RED),
            new Fruit("Orange", 50, Color.ORANGE),
            new Fruit("Banana", 200, Color.YELLOW),
            new Fruit("Grape", 50, Color.GREEN),
            new Fruit("Strawberry", 50, Color.RED),
            new Fruit("Kiwi", 50, Color.YELLOW),
            new Fruit("Pineapple", 70, Color.YELLOW),
            new Fruit("Mango", 50, Color.YELLOW),
            new Fruit("Watermelon", 150, Color.GREEN),
            new Fruit("Peach", 65, Color.YELLOW),
            new Fruit("Pear", 50, Color.YELLOW),
            new Fruit("Apple", 80, Color.GREEN),
        };

        var arrayList = new ArrayList<Fruit>(Arrays.asList(fruits));
        arrayList
            .stream()
            .filter(new FruitHeavyWeightPredicate()::test)
            .collect(Collectors.toList())
            .forEach(System.out::println);

        arrayList
            .stream()
            .filter(new FruitColorPredicate(Color.YELLOW)::test)
            .collect(Collectors.toList())
            .forEach(System.out::println);

        //  Find all fruit that are Red and heavy
        Predicate<? super Fruit> redAndHeavyFruit = fruit ->
            fruit.getColor() == Color.RED && fruit.getWeight() > 80;
        arrayList
            .stream()
            .filter(redAndHeavyFruit)
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }
}

class FruitHeavyWeightPredicate implements FruitPredicate {

    @Override
    public boolean test(Fruit fruit) {
        return fruit.getWeight() > 100;
    }
}

class FruitColorPredicate implements FruitPredicate {

    private final Color color;

    public FruitColorPredicate(Color color) {
        this.color = color;
    }

    @Override
    public boolean test(Fruit fruit) {
        return fruit.getColor() == this.color;
    }
}

record Fruit(String name, int weight, Color color) {
    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }
}
