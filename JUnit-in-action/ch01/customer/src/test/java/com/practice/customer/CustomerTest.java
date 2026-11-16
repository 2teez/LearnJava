package com.practice.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private static String FIRSTNAME = "James";
    private static String LASTNAME = "Gosling";

    @Nested
    class CustomerNestedClass {

        private static String MIDDLENAME = "Java";

        @Test
        @DisplayName("Test customer nested class builder.")
        public void customerBuilderTest() throws ParseException {
            var date = new SimpleDateFormat("dd-mm-yyyy");
            var customer = new Customer.Builder(
                Gender.MALE,
                FIRSTNAME,
                LASTNAME
            )
                .withMiddleName(MIDDLENAME)
                .withBecomeCustomer(date.parse("04-04-1990"))
                .build();

            assertAll(() -> {
                assertEquals(Gender.MALE, customer.getGender());
                assertEquals(FIRSTNAME, customer.getFirstName());
            });
        }
    }
}
