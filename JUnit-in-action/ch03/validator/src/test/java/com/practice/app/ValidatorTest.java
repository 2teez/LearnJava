package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {

    private static String PASSWORD = "validate";

    @Test
    @DisplayName("constructor should set the password.")
    public void constructorShouldSetPassword() {
        var access = new Validator(PASSWORD);
        assertThat(access.getPassword()).isEqualTo(PASSWORD);
    }

    @ParameterizedTest
    @DisplayName(
        "validate method should check for empty or null input password."
    )
    @CsvSource(
        value = {
            //"null, null",
            "'', ''",
            //"null, secret",
            "secret, null",
            "'', secret",
            "secret, ''",
        },
        nullValues = "null"
    )
    public void validateMethodShouldCheckForEmptyOrNullPassword(
        String setPassword,
        String actualPassword
    ) {
        var access = new Validator(setPassword);
        assertThat(access.validate(actualPassword))
            .as("false for either null or empty password.")
            .isFalse();
    }
}
