package com.java.practice.factorydesign.abstracts;

public class FordFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new FordCar();
    }

    @Override
    public Truck createTruck() {
        return new FordTruck();
    }
}