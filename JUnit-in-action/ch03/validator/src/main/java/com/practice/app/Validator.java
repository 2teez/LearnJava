package com.practice.app;

public class Validator {

    private String password;

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
        return this.password.equals(password);
    }

    public String getPassword() {
        return this.password;
    }
}
