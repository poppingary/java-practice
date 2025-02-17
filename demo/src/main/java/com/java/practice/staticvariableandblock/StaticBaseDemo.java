package com.java.practice.staticvariableandblock;

public class StaticBaseDemo {
    static int i = 10;

    static {
        m1();
        System.out.println("First static block");
    }

    public static void main(String[] args) {
        m1();
        System.out.println("Main method");
    }

    public static void m1() {
        System.out.println(j);
    }

    static {
        System.out.println("Second static block");
    }

    static int j = 20;
}

class StaticDerivedDemo extends StaticBaseDemo {
    static int x = 100;

    static {
        m2();
        System.out.println("Derived first static block");
    }

    public static void main(String[] args) {
        m2();
        System.out.println("Derived main");
    }

    public static void m2() {
        System.out.println(y);
    }

    static {
        System.out.println("Derived second static block");
    }

    static int y = 200;
}