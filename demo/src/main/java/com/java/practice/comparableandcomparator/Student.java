package com.java.practice.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student implements Comparable<Student> {
    private final String name;
    private final int id;
    private final double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(this.id, s.id);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("John", 2, 3.9),
                new Student("Thomas", 1, 3.8),
                new Student("George", 3, 3.4)
        ));

        Collections.sort(students);
        System.out.println(students);
        students.sort(new GpaComparator());
        System.out.println(students);
        students.sort(new NameComparator());
        System.out.println(students);
    }
}