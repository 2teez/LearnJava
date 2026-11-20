package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.params.ParameterizedTest;
import org.junit.jupiter.api.params.provider.CsvSource;

public class StringsTest {

    @Test
    @DisplayName("check string is properly reversed.")
    public void str_reverse_checker() {
        var expected = "dlroW , olleH";
        var actual = Strings.reverse("Hello, World");
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName(
        "check several strings of various types gives a proper reversed output."
    )
    @CsvSource({ "123, 321", "howdy, ydwoh", ", " })
    public void various_str_reversed(String actual, String expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
