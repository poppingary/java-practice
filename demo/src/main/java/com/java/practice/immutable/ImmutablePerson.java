package com.java.practice.immutable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class ImmutablePerson {
    private final String name;
    private final LocalDate birthDate;
    private final Address address;
    private final List<String> hobbies;

    public ImmutablePerson(String name, LocalDate birthDate, Address address, List<String> hobbies) throws CloneNotSupportedException {
        this.name = name;
        this.birthDate = birthDate;
        this.address = (Address) address.clone();
        this.hobbies = new ArrayList<>(hobbies);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("123 Main St", "Any town", "NY", "12345");
        List<String> hobbies = List.of("Reading", "Swimming");
        ImmutablePerson immutablePerson = new ImmutablePerson("Gary", LocalDate.of(1989, 8, 9), address, hobbies);
        System.out.println("Before modification");
        System.out.println(immutablePerson);

        // Attempting to modify the internal state will not affect the ImmutablePerson object
        immutablePerson.getBirthDate().plusYears(10);
        immutablePerson.getAddress().setStreet("456 Elm St");
        immutablePerson.getHobbies().add("Hiking");
        System.out.println();

        System.out.println("After modification");
        System.out.println(immutablePerson);
    }
}