package com.java.practice.factorydesign.factory;

public class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }

    @Override
    public void park() {
        System.out.println("Parking a car");
    }
}