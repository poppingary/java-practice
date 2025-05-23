package com.java.practice.functionalinterface;

import java.util.List;

public record Person(String name, int age, String email) {
    public Person {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }

    public static List<Person> createList() {
        return List.of(
                new Person("Curry", 10, "curry@x.com"),
                new Person("Lebron", 15, "lebron@x.com"),
                new Person("Durant", 20, "durant@x.com"),
                new Person("John", 25, "john@x.com"),
                new Person("Phil", 55, "phil@x.com"),
                new Person("Betty", 85, "betty@x.com")
        );
    }

    public void printPerson() {
        System.out.println(this);
    }
}