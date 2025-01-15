package com.java.practice.factorydesign.factory;

public class Main {
    public static void main(String[] args) {
        Vehicle truck = VehicleFactory.getVehicle("truck");
        truck.drive();
        truck.park();

        Vehicle car = VehicleFactory.getVehicle("car");
        car.drive();
        car.park();
    }
}