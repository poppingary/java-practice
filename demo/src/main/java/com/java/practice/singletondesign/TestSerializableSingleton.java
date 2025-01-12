package com.java.practice.singletondesign;

import java.io.*;

public class TestSerializableSingleton implements Serializable {
    private static final TestSerializableSingleton INSTANCE = new TestSerializableSingleton();

    private TestSerializableSingleton() {

    }

    public static TestSerializableSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSerializableSingleton instance1 = TestSerializableSingleton.getInstance();
        System.out.println("instance1 hashCode:- " + instance1.hashCode());

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(instance1);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.ser"));
        TestSerializableSingleton instance2 = (TestSerializableSingleton) in.readObject();
        in.close();
        System.out.println("instance2 hashCode:- " + instance2.hashCode());
    }
}