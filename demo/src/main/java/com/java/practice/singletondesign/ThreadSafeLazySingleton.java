package com.java.practice.singletondesign;

public class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton instance;

    private ThreadSafeLazySingleton() {

    }

    public static synchronized ThreadSafeLazySingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazySingleton();
        }

        return instance;
    }

    public static void main(String[] args) {
            ThreadSafeLazySingleton object1 = ThreadSafeLazySingleton.getInstance();
            System.out.println(object1.hashCode());

            ThreadSafeLazySingleton object2 = ThreadSafeLazySingleton.getInstance();
            System.out.println(object2.hashCode());
    }
}