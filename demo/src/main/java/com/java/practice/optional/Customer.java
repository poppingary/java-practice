package com.java.practice.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;
}