package com.practice.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerMain {

    public static void main(String... args) throws ParseException {
        var date = new SimpleDateFormat("MM-dd-yyyy");
        Customer customer = new Customer.Builder(
            Gender.MALE,
            "James",
            "Gosling"
        )
            .withMiddleName("Java")
            .withBecomeCustomer(date.parse("04-12-1990"))
            .build();
    }
}
