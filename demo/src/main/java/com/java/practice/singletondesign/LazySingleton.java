package com.java.practice.singletondesign;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }

    public static void main(String[] args) {
        LazySingleton object1 = LazySingleton.getInstance();
        System.out.println(object1.hashCode());

        LazySingleton object2 = LazySingleton.getInstance();
        System.out.println(object2.hashCode());
    }
}