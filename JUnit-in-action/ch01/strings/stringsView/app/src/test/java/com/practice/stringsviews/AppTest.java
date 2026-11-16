package com.practice.stringsviews;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void reverse_non_string() {
        // given
        String emptyString = "";

        // when
        String reversedString = App.reverse(emptyString);
        // then
        assertEquals("", reversedString);
        assertEquals("cba", App.reverse("cba"));
    }
}
