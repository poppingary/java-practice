package com.java.practice.immutable;

import java.time.LocalDate;
import java.util.Arrays;

public record ImmutablePerson(String name, LocalDate birthDate, Address address, String[] hobbies) {
    public ImmutablePerson(String name, LocalDate birthDate, Address address, String[] hobbies) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = new Address(address.getStreet(), address.getCity(), address.getState(), address.getZip());
        this.hobbies = hobbies.clone();
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Any town", "NY", "12345");
        String[] hobbies = new String[]{"Reading", "Swimming"};
        ImmutablePerson immutablePerson = new ImmutablePerson("Gary", LocalDate.of(1989, 8, 9), address, hobbies);
        System.out.println("Before modification");
        System.out.println(immutablePerson);
        System.out.println(immutablePerson.birthDate());
        System.out.println(immutablePerson.address());
        System.out.println(Arrays.toString(immutablePerson.hobbies()));

        // Attempting to modify the internal state will not affect the ImmutablePerson object
        address.setStreet("456 Elm St");
        hobbies[0] = "Cooking";
        System.out.println();

        System.out.println("After modification");
        System.out.println(immutablePerson);
        System.out.println(immutablePerson.birthDate());
        System.out.println(immutablePerson.address());
        System.out.println(Arrays.toString(immutablePerson.hobbies()));
    }
}