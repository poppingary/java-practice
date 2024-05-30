package com.java.practice.comparableandcomparator;

import java.util.*;

public class ComparableAndComparatorExample {
    public static void main(String[] args) {
        sort();
    }

    public static void sort() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("John", 2, 3.9),
                new Student("Thomas", 1, 3.8),
                new Student("George", 3, 3.4)
        ));

        System.out.println("***** Comparable by using list sort (Natural Ordering) (Sort by Score) *****");
        students.sort(Student::compareTo);
        printStudents(students);

        System.out.println("***** Comparable by using tree set (Natural Ordering) (Sort by Score) *****");
        printStudents(new TreeSet<>(students)); // Utilize TreeSet for natural ordering

        System.out.println("***** Comparator (Sort by Name) *****");
        printStudents(students, new NameComparator());

        System.out.println("***** Comparator (Sort by Id) *****");
        printStudents(students, (s1, s2) -> Integer.compare(s1.getId(), s2.getId()));

        System.out.println("***** Comparator (Sort by Score) *****");
        printStudents(students, Comparator.comparingDouble(Student::getGpa));
    }

    private static void printStudents(Collection<Student> students) {
        students.forEach(System.out::println);
        System.out.println();
    }

    private static void printStudents(List<Student> students, Comparator<Student> comparator) {
        students.sort(comparator);
        students.forEach(System.out::println);
        System.out.println();
    }
}