package com.java.practice.singletondesign;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestReflectionSingleton {
    private static final TestReflectionSingleton INSTANCE = new TestReflectionSingleton();

    private TestReflectionSingleton() {

    }

    public static TestReflectionSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        TestReflectionSingleton instance1 = TestReflectionSingleton.getInstance();
        TestReflectionSingleton instance2 = null;

        Constructor<?>[] constructors = TestReflectionSingleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            // Below code will destroy the singleton pattern
            constructor.setAccessible(true);
            instance2 = (TestReflectionSingleton) constructor.newInstance();
        }

        System.out.println("instance1 hashCode:- " + instance1.hashCode());
        assert instance2 != null;
        System.out.println("instance2 hashCode:- " + instance2.hashCode());
    }
}
