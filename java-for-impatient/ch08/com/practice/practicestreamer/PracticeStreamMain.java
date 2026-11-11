package com.practice.practicestreamer;

import java.time.Year;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//import java.util.stream;

public class PracticeStreamMain {

    public static void main(String[] args) {
        var library = new Library<Book>();
        library.addItem(
            new Book(
                "Fundamentals of Chinese Fingernail Image",
                Arrays.asList("Li", "Fu", "Li"),
                new int[] { 256 },
                Year.of(2014),
                25.2,
                Topic.MEDICINE
            )
        );

        var books = List.of(
            new Book(
                "Compilers: Principles, Techniques and Tools",
                Arrays.asList("Aho", "Lam", "Sethi", "Ullman"),
                new int[] { 1009 },
                Year.of(2006),
                23.6,
                Topic.COMPUTING
            ),
            new Book(
                "Voss",
                Arrays.asList("Patrick White"),
                new int[] { 478 },
                Year.of(1957),
                19.8,
                Topic.FICTION
            ),
            new Book(
                "Lord of the Rings",
                Arrays.asList("Tolkien"),
                new int[] { 531, 416, 624 },
                Year.of(1955),
                23.0,
                Topic.FICTION
            )
        );
        library.addItems(books);
        library.getBooks().stream().forEach(System.out::println);
    }
}
