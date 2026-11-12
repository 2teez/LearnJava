package com.practice.practicestreamer;

import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
        //var library = lib.getBooks();
        library.stream().map(Book::getPubDate).forEach(System.out::println);
        library
            .stream()
            .filter(b -> b.getTopic() == Topic.COMPUTING)
            .forEach(System.out::println);
        library.stream().map(Book::getTitle).forEach(System.out::println);
        library
            .stream()
            .sorted(Comparator.comparing(Book::getTitle))
            .forEach(System.out::println);
    }
}
