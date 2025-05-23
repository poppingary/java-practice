package com.java.practice.immutable;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public final class ImmutablePerson {
    private final String name;
    private final LocalDate birthDate;
    private final Address address;
    private final List<String> hobbies;

    public ImmutablePerson(String name, LocalDate birthDate, Address address, List<String> hobbies) throws CloneNotSupportedException {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.hobbies = hobbies;
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
        // Make address and hobbies immutable
        Address address = new Address("123 Main St", "Any town", "NY", "12345");
        List<String> hobbies = List.of("Reading", "Swimming");

        ImmutablePerson immutablePerson = new ImmutablePerson("Gary", LocalDate.of(1989, 8, 9), address, hobbies);
        System.out.println("Before modification");
        System.out.println(immutablePerson);

        // This will not work as String is immutable
        immutablePerson.getBirthDate().plusYears(10);

        // This will not work as Address is immutable
//        immutablePerson.getAddress().setCity("New City");
//        address.setCity("New City");

        // This will not work as List.of() creates an immutable list (UnsupportedOperationException)
//        immutablePerson.getHobbies().add("Hiking");
//        hobbies.add("Hiking");

        System.out.println();

        System.out.println("After modification");
        System.out.println(immutablePerson);
    }
}