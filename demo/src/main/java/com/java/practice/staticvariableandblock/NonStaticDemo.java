package com.java.practice.staticvariableandblock;

public class NonStaticDemo {
    int i = 10;

    {
        m1();
        System.out.println("First instance block");
    }

    NonStaticDemo() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("Main");
    }

    public void m1() {
        System.out.println(j);
    }

    {
        System.out.println("Second instance block");
    }

    int j = 20;
}
