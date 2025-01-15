package com.java.practice.factorydesign.factory;

public class Main {
    public static void main(String[] args) {
        Vehicle truck = VehicleFactory.createVehicle("truck");
        truck.drive();
        truck.park();

        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();
        car.park();
    }
}