package com.practice.practicestreamer;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book {

    private String title;
    private List<String> authors;
    private int[] pageCounts;
    private Topic topic;
    private Year pubDate;
    private double bookHeight;

    public Book(
        String title,
        List<String> authors,
        int[] pageCounts,
        Year pubDate,
        double bookHeight,
        Topic topic
    ) {
        this.title = title;
        this.authors = authors;
        this.pageCounts = pageCounts;
        this.pubDate = pubDate;
        this.bookHeight = bookHeight;
        this.topic = topic;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public int[] getPageCount() {
        return this.pageCounts;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public Year getPubDate() {
        return this.pubDate;
    }

    public double getHeight() {
        return this.bookHeight;
    }

    @Override
    public String toString() {
        return String.format(
            "Book(%s, %s, %s, %s, %.1f, %s)",
            this.title,
            this.authors,
            Arrays.toString(this.pageCounts),
            this.pubDate.toString(),
            this.bookHeight,
            this.topic.name()
        );
    }
}
