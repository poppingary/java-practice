package com.java.practice.singletondesign;

public class DoubleCheckedLazySingleton {
    private static DoubleCheckedLazySingleton instance;

    private DoubleCheckedLazySingleton() {

    }

    public static DoubleCheckedLazySingleton getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckedLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLazySingleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckedLazySingleton object1 = DoubleCheckedLazySingleton.getInstance();
        System.out.println("instance1 hashCode:- " + object1.hashCode());

        DoubleCheckedLazySingleton object2 = DoubleCheckedLazySingleton.getInstance();
        System.out.println("instance1 hashCode:- " + object2.hashCode());
    }
}