package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CliReaderTest {

    private static final String GREET = "Hello";

    @Test
    @DisplayName("getUserInput should return a trimmed string.")
    public void getUserInputShouldReturnTrimmedString() {
        var originalIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(" Hello  \n".getBytes()));
            var gotten = CliReader.getUserInput("Greet: ");
            assertThat(gotten).isEqualTo(GREET);
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    @Disabled
    @DisplayName("input from console should return a trimmed string.")
    public void inputFromConsoleShouldReturnTrimmedString() {
        var gotten = CliReader.getUserInput("Name: ");
        assertThat(gotten).isEqualTo(GREET);
    }
}
