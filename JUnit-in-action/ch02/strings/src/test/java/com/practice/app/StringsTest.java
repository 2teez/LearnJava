package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringsTest {

    @Test
    @DisplayName("check string length.")
    public void str_length_checker() {
        var expectedValue = "Howdy...".length();
        var gottenValue = AppMain.strLen("Howdy...");
        assertEquals(gottenValue, expectedValue);
    }
}
