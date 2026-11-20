package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringsTest {

    @Test
    @DisplayName("check string is properly reversed.")
    public void strReverseChecker() {
        var expected = "dlroW ,olleH";
        var actual = Strings.reverse("Hello, World");
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName(
        "check several strings of various types gives a proper reversed output."
    )
    @CsvSource({ "123, 321", "howdy, ydwoh", "mom, mom" })
    public void variousStrReversed(String actual, String expected) {
        assertThat(Strings.reverse(actual)).isEqualTo(expected);
    }

    @Test
    @DisplayName("empty input should give a null pointer exception.")
    public void emptyInputShouldGiveNullPointerException() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
            Strings.reverse(null);
        });
    }
}
