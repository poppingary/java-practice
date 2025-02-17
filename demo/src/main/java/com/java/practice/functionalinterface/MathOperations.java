package com.java.practice.functionalinterface;

@FunctionalInterface
public interface MathOperations {
    void operation(int a, int b);

    default void defaultMethod() {
        System.out.println("This is default method!");
    }

    static void staticMethod() {
        System.out.println("This is static method!");
    }
}
