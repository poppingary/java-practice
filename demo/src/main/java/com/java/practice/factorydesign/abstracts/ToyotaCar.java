package com.java.practice.factorydesign.abstracts;

public class ToyotaCar implements Car {
    @Override
    public void drive() {
        System.out.println("Toyota Car is driving");
    }

    @Override
    public void park() {
        System.out.println("Toyota Car is parked");
    }
}