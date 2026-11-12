package com.practice.practicestreamer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Library<T> {

    private List<T> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public boolean addItem(T book) {
        return this.books.add(book);
    }

    public boolean addItems(List<T> books) {
        return this.books.addAll(books);
    }

    public Stream<T> stream() {
        return this.books.stream();
    }

    @Override
    public String toString() {
        return books.toString();
    }
}
