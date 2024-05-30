package com.java.practice.objectcomparison;

import java.util.HashSet;
import java.util.Set;

public class ObjectComparisonExample {
    public static void main(String[] args) {
        printObjectComparison();
        printHashSetComparison();
    }

    public static void printObjectComparison() {
        Employee employee1 = new Employee(918, "Maria");
        Employee employee2 = new Employee(918, "Maria");

        System.out.println("***** Object comparison *****");
        System.out.println(getHashCodeMessage(employee1));
        System.out.println(getHashCodeMessage(employee2));
        System.out.println();

//        If only override the equals() method
//        Hashcode of Employee{id=918, name='Maria'} = 951007336
//        Hashcode of Employee{id=918, name='Maria'} = 531885035

//        If override the equals() and hashCode() methods
//        Hashcode of Employee{id=918, name='Maria'} = 74143169
//        Hashcode of Employee{id=918, name='Maria'} = 74143169
    }

    public static void printHashSetComparison() {
        Employee employee1 = new Employee(918, "Maria");
        Employee employee2 = new Employee(918, "Maria");

        System.out.println("----- Object comparison in the HashSet -----");
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);
        employeeSet.forEach(System.out::println);
        System.out.println();

//        If only override the equals() method
//        Employee{id=918, name='Maria'}
//        Employee{id=918, name='Maria'}

//        If override the equals() and hashCode() methods
//        Employee{id=918, name='Maria'}
    }

    private static String getHashCodeMessage(Employee employee) {
        return "Hashcode of " + employee + " = " + employee.hashCode();
    }
}