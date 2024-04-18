package com.java.practice.collectionsort;

import java.util.*;

public class Sort {
    public void print() {
        System.out.println("----- Before Sort -----");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("John", 2, 3.9));
        studentSet.add(new Student("Thomas", 1, 3.8));
        studentSet.add(new Student("George", 3, 3.4));
        for (Student student : studentSet) {
            System.out.println(student);
        }

        System.out.println("----- After Sort -----");
        Set<Student> sortStudentSet = new TreeSet<>();
        sortStudentSet.add(new Student("John", 2, 3.9));
        sortStudentSet.add(new Student("Thomas", 1, 3.8));
        sortStudentSet.add(new Student("George", 3, 3.4));
        sortStudentSet.forEach(System.out::println);

        System.out.println("----- Original -----");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John", 2, 3.9));
        studentList.add(new Student("Thomas", 1, 3.8));
        studentList.add(new Student("George", 3, 3.4));
        studentList.forEach(System.out::println);

        System.out.println("----- Sort by name -----");
        studentList.sort(new NameSorter());
        studentList.forEach(System.out::println);

        System.out.println("----- Sort by score -----");
        studentList.sort(new ScoreSorter());
        studentList.forEach(System.out::println);
    }
}
