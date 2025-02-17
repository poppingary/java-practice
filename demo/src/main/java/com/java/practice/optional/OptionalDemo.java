package com.java.practice.optional;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "John Doe", null, "1234567890");

        // Using empty to create an empty Optional
        Optional<Object> optionalEmpty = Optional.empty();
        System.out.println("Optional empty: " + optionalEmpty);

        // Using of to create an Optional that cannot be null
//        Optional<String> emailOptional = Optional.of(customer.getEmail());
//        System.out.println("Optional of email: " + emailOptional); // This will throw NullPointerException

        // Using ofNullable to create an Optional that can be null
        Optional<String> emailOptionalSafe = Optional.ofNullable(customer.getEmail());
        System.out.println("Optional ofNullable email: " + emailOptionalSafe); // This will not throw an exception

        // Using isPresent to check if value is present
        if (emailOptionalSafe.isPresent()) {
            System.out.println("Email is present: " + emailOptionalSafe.get());
        } else {
            System.out.println("Email is not present");
        }

        // Using orElse to provide a default value
        System.out.println("Email or default: " + emailOptionalSafe.orElse("default@gmail.com"));

        // Using orElseThrow to provide a default value using a Supplier
//        System.out.println("Email or throw: " + emailOptionalSafe.orElseThrow(() -> new RuntimeException("Email is not present")));

        // Using map to transform the value
        System.out.println("To uppercase email: " + emailOptionalSafe.map(String::toUpperCase).orElse("default@gmail.com"));

        List<Customer> customers = getCustomers();
        customers.parallelStream()
                .filter(c -> c.getEmail().equals("alice_johnson@gmail.com"))
                .findAny()
                .ifPresentOrElse(
                        c -> System.out.println("Found customer: " + c),
                        () -> System.out.println("Customer not found")
                );
    }

    private static List<Customer> getCustomers() {
        return List.of(
                new Customer(1, "John Doe", "john_doe@gmail.com", "1234567890"),
                new Customer(2, "Jane Smith", "jane_smith@gmail.com", "0987654321"),
                new Customer(3, "Alice Johnson", "alice_johnson@gmail.com", "1122334455"),
                new Customer(4, "Bob Brown", "bob_brown@gmail.com", "5566778899"),
                new Customer(5, "Charlie Davis", "charlie_davis@gmail.com", "9988776655"));
    }
}