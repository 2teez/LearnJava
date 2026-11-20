package com.practice.app;

public class Validator {

    private String password;

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

        if (
            checkPasswordLength(this.password) > 8 &&
            this.password.equals(password)
        ) {
            result = true;
        }

        return result;
    }

    private int checkPasswordLength() {
        return alph.length();
    }

    public String getPassword() {
        return this.password;
    }
}
