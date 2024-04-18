package com.java.practice.collectionsort;

import java.util.*;

public class StudentSorter {
    public void sort() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("John", 2, 3.9),
                new Student("Thomas", 1, 3.8),
                new Student("George", 3, 3.4)
        ));

        System.out.println("***** Comparable (Natural Ordering) *****");
        printStudents(new TreeSet<>(students)); // Utilize TreeSet for natural ordering

        System.out.println("***** Comparator (Sort by Name) *****");
        printStudents(students, new NameComparator());

        System.out.println("***** Comparator (Sort by Score) *****");
        printStudents(students, new GpaComparator());
    }

    private void printStudents(Collection<Student> students) {
        students.forEach(System.out::println);
        System.out.println();
    }

    private void printStudents(List<Student> students, Comparator<Student> comparator) {
        students.sort(comparator);
        students.forEach(System.out::println);
        System.out.println();
    }
}
