package com.java.practice.factorydesign.abstracts;

public class FordTruck implements Truck {
    @Override
    public void drive() {
        System.out.println("Ford Truck is driving");
    }

    @Override
    public void park() {
        System.out.println("Ford Truck is parking");
    }
}