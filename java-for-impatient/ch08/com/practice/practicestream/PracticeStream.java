package com.practice.practicestream;

import static java.lang.System.out;

import java.util.stream.Stream;

public class PracticeStream {

    public static void main(String[] args) {
        var numbers = Stream.of(1, 2, 3, 4);
        numbers.forEach(out::println);
        Stream.generate(Math::random).limit(56).forEach(out::println);
    }
}
