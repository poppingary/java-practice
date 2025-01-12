package com.java.practice.singletondesign;

public class TestCloneSingleton extends MyClone {
    private static final TestCloneSingleton INSTANCE = new TestCloneSingleton();

    private TestCloneSingleton() {

    }

    public static TestCloneSingleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestCloneSingleton instance1 = TestCloneSingleton.getInstance();
        System.out.println("instance1 hashCode:- " + instance1.hashCode());

        TestCloneSingleton instance2 = (TestCloneSingleton) instance1.clone();
        System.out.println("instance2 hashCode:- " + instance2.hashCode());
    }
}