package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidatorTest {

    private static String PASSWORD = "validate";
    private Validator access;

    @BeforeEach
    public void defaultClassConstructor() {
        access = new Validator(PASSWORD);
    }

    @Test
    @DisplayName("constructor should set the password.")
    public void constructorShouldSetPassword() {
        assertThat(access.getPassword()).isEqualTo(PASSWORD);
    }

    @ParameterizedTest
    @DisplayName(
        "validate method should check for empty or null input password."
    )
    @CsvSource(
        value = { "'', ''", "secret, null", "'', secret", "secret, ''" },
        nullValues = "null"
    )
    public void validateMethodShouldCheckForEmptyOrNullPassword(
        String setPassword,
        String actualPassword
    ) {
        assertThat(access.validate(actualPassword))
            .as("false for either null or empty password.")
            .isFalse();
    }

    @ParameterizedTest
    @DisplayName(
        "validate method should throw NullPointerException, when call to validate on null."
    )
    @CsvSource(value = { "null, null", "null, secret" }, nullValues = "null")
    public void validateMethodShouldThrowNullException(
        String setPassword,
        String actualPassword
    ) {
        access = new Validator(setPassword);
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> {
            access.validate(actualPassword);
        });
    }

    @Test
    @DisplayName("the password should be more or less than 8 letters.")
    public void validateMethodShouldHaveMoreorLessThanEightLetter() {
        assertThat(access.getPassword().length()).isEqualTo(8);
    }
}
