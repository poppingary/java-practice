package com.java.practice.factorydesign.factory;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle truck = vehicleFactory.createVehicle("truck");
        truck.drive();
        truck.park();

        Vehicle car = vehicleFactory.createVehicle("car");
        car.drive();
        car.park();
    }
}