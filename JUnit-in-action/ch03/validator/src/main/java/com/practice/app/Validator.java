package com.practice.app;

public class Validator {

    private final String password;
    private static final int PASSWORD_LENGTH = 8;

    public Validator(String password) {
        this.password = password;
    }

    public boolean validate(String password) {
        if (this.password == null) {
            throw new NullPointerException("Password can't be null");
        } else if (
            password == null || this.password.isEmpty() || password.isEmpty()
        ) {
            return false;
        }

        return (
            checkPasswordLength() &&
            checkPasswordOtherProperties() &&
            this.password.equals(password)
        );
    }

    private boolean checkPasswordLength() {
        return this.password.length() >= PASSWORD_LENGTH;
    }

    private boolean checkPasswordOtherProperties() {
        var hasAtLestOneCapitalLetter = this.password
            .chars()
            .anyMatch(Character::isUpperCase);
        var hasAtLestOneLowerCaseLetter = this.password
            .chars()
            .anyMatch(Character::isLowerCase);
        var hasAtLeastTwoDigits =
            this.password.chars().filter(Character::isDigit).count() >= 2;
        var hasAtLeastOneNonAlphanumeric = this.password
            .chars()
            .anyMatch(Character::isLetterOrDigit);

        return (
            hasAtLestOneCapitalLetter &&
            hasAtLeastTwoDigits &&
            hasAtLestOneLowerCaseLetter &&
            hasAtLeastOneNonAlphanumeric
        );
    }

    public String getPassword() {
        return this.password;
    }
}
