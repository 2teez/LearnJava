package com.practice.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTestSingle {

    private static final String PASSWORD = "v&liDat35";
    private static final int LENGTH = 8;

    @Test
    @DisplayName(
        "validates that the password should have a length more than 8 "
    )
    public void validatesPasswordWithSeveralCriteria() {
        var access = new Validator(PASSWORD);
        assertAll(
            "Checking several conditions",
            () -> {
                assertThat(access.getPassword())
                    .isNotNull()
                    .matches(".*?\\d{2,}.*?")
                    .matches(".*?[A-Z]{1,}.*?")
                    .matches(".*?[a-z]{1,}.*?")
                    .matches(".*?\\W{1,}.*?");
            },
            () -> {
                assertThat(access.getPassword().length()).isGreaterThan(LENGTH);
            }
        );
    }
}
