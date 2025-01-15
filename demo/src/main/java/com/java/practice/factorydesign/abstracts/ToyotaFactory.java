package com.java.practice.factorydesign.abstracts;

public class ToyotaFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new ToyotaCar();
    }

    @Override
    public Truck createTruck() {
        return new ToyotaTruck();
    }
}