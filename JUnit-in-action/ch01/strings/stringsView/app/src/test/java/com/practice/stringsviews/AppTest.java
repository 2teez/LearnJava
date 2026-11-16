package com.practice.stringsviews;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
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
        assertEquals("cba", App.reverse("abc"));
    }

    @Test
    void reverse_non_string1() {
        try {
            App.reverse(null);
            fail("reverse(null) should return IllegalArgumentException.");
        } catch (IllegalArgumentException iae) {}
    }

    @Test
    void reverse_non_string2() {
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
