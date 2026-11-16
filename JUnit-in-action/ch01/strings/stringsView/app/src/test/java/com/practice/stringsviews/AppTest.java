package com.practice.stringsviews;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    @DisplayName("reverse non null string")
    void reverseNonNullString() {
        // given
        String emptyString = "";

        // when
        String reversedString = App.reverse(emptyString);
        // then
        assertEquals("", reversedString);
        assertEquals("cba", App.reverse("abc"));
    }

    @Test
    @DisplayName("reverse non null string with exception using fail function")
    void reverseNonNullStringWithFail() {
        try {
            App.reverse(null);
            fail("reverse(null) should return IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {}
    }

    @Test
    @DisplayName(
        "reverse non null string with exception using assertThrows function"
    )
    void reverseNonNullStringWithAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            App.reverse(null);
        });
    }

    @Test
    void reverse_string_timeout_1s() {
        assertTimeout(Duration.ofMillis(1), () -> {
            App.reverse("abc");
        });
    }
}
