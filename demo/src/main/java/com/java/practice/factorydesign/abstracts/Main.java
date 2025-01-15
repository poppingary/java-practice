package com.java.practice.factorydesign.abstracts;

public class Main {
    public static void main(String[] args) {
        VehicleFactory toyotaFactory = new ToyotaFactory();
        Car toyotaCar = toyotaFactory.createCar();
        toyotaCar.drive();
        toyotaCar.park();
        Truck toyotaTruck = toyotaFactory.createTruck();
        toyotaTruck.drive();
        toyotaTruck.park();

        VehicleFactory fordFactory = new FordFactory();
        Car fordCar = fordFactory.createCar();
        fordCar.drive();
        fordCar.park();
        Truck fordTruck = fordFactory.createTruck();
        fordTruck.drive();
        fordTruck.park();
    }
}