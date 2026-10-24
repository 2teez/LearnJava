package com.practice.playwithstrings;

import static com.practice.jutils.Jutils.utils;

import java.util.StringJoiner;

public class PlayWithStrings {

    public static void main(String[] args) {
        final String[] langs = { "clojure", "java", "javascript", "rust" };
        var joiner = new StringJoiner("; ", "{ ", " }");
        for (var lang : langs) joiner.add(lang);
        utils.prints("Using StringJoiner: ", joiner);
        // using String join static method
        utils.prints("Using String method join: ", String.join("; ", langs));
    }
}
