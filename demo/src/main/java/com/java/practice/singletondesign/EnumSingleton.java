package com.java.practice.singletondesign;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum EnumSingleton {
    INSTANCE;

    public void performOperation(String instanceName) {
        System.out.println(instanceName + " hashCode:- " + this.hashCode());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        instance1.performOperation("instance1");

        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        instance2.performOperation("instance2");

        // Reflection
        Constructor<?>[] constructors = EnumSingleton.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            EnumSingleton instance3 = null;
            try {
                instance3 = (EnumSingleton) constructor.newInstance();
                instance3.performOperation("instance3");
            } catch (Exception e) {
                System.out.println("Cannot reflectively create enum objects");
            }
        }

        // Serialization
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            out.writeObject(instance1);
        } catch (IOException e) {
            System.out.println("Serialization failed: " + e.getMessage());
        }

        EnumSingleton instance4 = null;
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            instance4 = (EnumSingleton) in.readObject(); // Corrected deserialization syntax
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization failed: " + e.getMessage());
        }

        instance4.performOperation("instance4");

        // Clone
        try {
            EnumSingleton instance5 = (EnumSingleton) instance1.clone();
            instance5.performOperation("instance5");
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported exception");
        }

        // Thread safety
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            EnumSingleton instance6 = EnumSingleton.INSTANCE;
            instance6.performOperation("instance6");
        });
        executorService.submit(() -> {
            EnumSingleton instance7 = EnumSingleton.INSTANCE;
            instance7.performOperation("instance7");
        });
        executorService.shutdown();
    }
}