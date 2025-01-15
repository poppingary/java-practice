package com.java.practice.factorydesign.factory;

public class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck");
    }

    @Override
    public void park() {
        System.out.println("Parking a truck");
    }
}