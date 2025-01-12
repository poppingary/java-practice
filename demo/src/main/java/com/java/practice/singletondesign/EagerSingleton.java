package com.java.practice.singletondesign;

public class EagerSingleton {
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        EagerSingleton object1 = EagerSingleton.getInstance();
        System.out.println("instance1 hashCode:- " + object1.hashCode());

        EagerSingleton object2 = EagerSingleton.getInstance();
        System.out.println("instance1 hashCode:- " + object2.hashCode());
    }
}