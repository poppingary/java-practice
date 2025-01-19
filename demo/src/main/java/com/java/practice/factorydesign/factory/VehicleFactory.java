package com.java.practice.factorydesign.factory;

public class VehicleFactory {
    public Vehicle createVehicle(String vehicleType) {
        return switch (vehicleType) {
            case "car" -> new Car();
            case "truck" -> new Truck();
            default -> null;
        };
    }
}