package com.practice.practicestreamer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Library<T> {

    private List<T> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library<T> addItem(T book) {
        this.books.add(book);
        return this;
    }

    public Library<T> addItems(List<T> books) {
        this.books.addAll(books);
        return this;
    }

    public List<T> getBooks() {
        return this.books;
    }

    @Override
    public String toString() {
        return Arrays.toString(books.toArray());
    }
}
