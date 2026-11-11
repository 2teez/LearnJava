package com.practice.practicestream;

import static java.lang.System;

import java.util.stream.Stream;

public class PracticeStream {

    public static void main(String[] args) {
        var numbers = Stream.of(1, 2, 3, 4);
        numbers.forEach(out::println);
    }
}
