package com.practice.customer;

import java.util.Date;

/**
 * class Customer
 * with instance variables: gender, firstname, lastname, middlename
 * and date of becoming a customer
 */

public class Customer {

    private String firstName;
    private String lastName;
    private String middleName;
    private Gender genderType;
    private Date customerDate;

    /**
     * Customer constructor
     * with gender, firstname, lastname, middlename and date of becoming a customer
     */
    public Customer(
        Gender genderType,
        String firstName,
        String lastName,
        String middleName,
        Date customerDate
    ) {
        this.genderType = genderType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.customerDate = customerDate;
    }

    /**
     * getGender
     * @return String for gender type
     */
    public Gender getGender() {
        return this.genderType;
    }

    /**
     * getFirstName
     * @return String of first name of the customer
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * getLastName
     * @return String of last name of the customer
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * getMiddleName
     * @return String of middle name of the customer
     */
    public String getMiddleName() {
        return this.middleName;
    }

    /**
     * getBecomeCustomer
     * @return String of first name of the customer
     */
    public String getBecomeCustomer() {
        return this.customerDate.toString();
    }

    @Override
    public String toString() {
        return String.format(
            "Customer(%s, %s, %s)",
            this.getGender(),
            this.getFirstName(),
            this.getBecomeCustomer()
        );
    }

    // static nested class builder
    public static class Builder {

        private final Gender genderType;
        private final String firstName;
        private final String lastName;
        private String middleName;
        private Date customerDate;

        public Builder(Gender gender, String firstname, String lastname) {
            this.genderType = gender;
            this.firstName = firstname;
            this.lastName = lastname;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withBecomeCustomer(Date customerDate) {
            this.customerDate = customerDate;
            return this;
        }

        public Customer build() {
            return new Customer(
                genderType,
                firstName,
                lastName,
                middleName,
                customerDate
            );
        }
    }
}
