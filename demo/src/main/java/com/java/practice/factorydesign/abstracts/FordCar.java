package com.java.practice.factorydesign.abstracts;

public class FordCar implements Car {
    @Override
    public void drive() {
        System.out.println("Ford Car is driving");
    }

    @Override
    public void park() {
        System.out.println("Ford Car is parking");
    }
}