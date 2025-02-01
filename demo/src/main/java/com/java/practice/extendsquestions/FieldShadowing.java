package com.java.practice.extendsquestions;

public class FieldShadowing {
    public static void main(String[] args) {
        Person p = new Student();
        System.out.println(p.age);
        p.printAge();
    }
}

class Person {
    public int age = 20;

    public void printAge() {
        System.out.println("Person age is: " + age);
    }
}

class Student extends Person {
    public int age = 10;

    public void printAge() {
        System.out.println("Student age is: " + age);
    }
}