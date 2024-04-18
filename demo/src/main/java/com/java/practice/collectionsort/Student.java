package com.java.practice.collectionsort;

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

    public int getId() {
        return id;
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
        int sortById = Long.compare(this.id, s.id);
        int sortByName = this.name.compareTo(s.getName());
        int sortByGpa = Double.compare(this.gpa, s.gpa);

        return sortByGpa;
    }
}