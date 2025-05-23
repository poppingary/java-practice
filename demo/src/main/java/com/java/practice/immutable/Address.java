package com.java.practice.immutable;

public record Address(String street, String city, String state, String zip) {
    public Address {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be null or blank");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        if (state == null || state.isBlank()) {
            throw new IllegalArgumentException("State cannot be null or blank");
        }
        if (zip == null || zip.isBlank()) {
            throw new IllegalArgumentException("Zip cannot be null or blank");
        }
    }
}