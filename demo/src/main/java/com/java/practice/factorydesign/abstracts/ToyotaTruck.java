package com.java.practice.factorydesign.abstracts;

public class ToyotaTruck implements Truck {
    @Override
    public void drive() {
        System.out.println("Toyota Truck is driving");
    }

    @Override
    public void park() {
        System.out.println("Toyota Truck is parking");
    }
}