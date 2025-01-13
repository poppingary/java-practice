package com.java.practice.extendsquestions;

public class TryCatchFinallyReturnFlow {
    private static int m1() {
        try {
            System.out.println("In try block");
            return 1;
        } catch (Exception e) {
            System.out.println("In catch block");
            return 2;
        } finally {
            System.out.println("In finally block");
            return 3;
        }
    }

    private static int m2() {
        try {
            System.out.println("In try block");
            System.out.println(10 / 0);
            return 1;
        } catch (Exception e) {
            System.out.println("In catch block");
            return 2;
        } finally {
            System.out.println("In finally block");
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(m1());
        System.out.println(m2());
    }
}
