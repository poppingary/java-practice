package com.java.practice.functionalinterface;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public void printPerson() {
        System.out.println(this);
    }
}