package com.practice.app;

public class Validator {

    private final String password;
    private final int PASSWORD_LENGTH = 8;

    public Validator(String password) {
        this.password = password;
    }

    public boolean validate(String password) {
        var result = false;
        if (this.password == null) {
            throw new NullPointerException("Password can't be null");
        } else if (
            password == null || this.password.isEmpty() || password.isEmpty()
        ) {
            return result;
        }

        if (checkPasswordLength() && this.password.equals(password)) {
            result = true;
        }

        return result;
    }

    private boolean checkPasswordLength() {
        if (this.password.length() <= PASSWORD_LENGTH) {
            return false;
        }
        return true;
    }

    public String getPassword() {
        return this.password;
    }
}
