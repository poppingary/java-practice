package com.java.practice.objectequality;

import java.util.HashSet;
import java.util.Set;

public class Comparison {
    public void printObjectComparison() {
        Employee employee1 = new Employee(918, "Maria");
        Employee employee2 = new Employee(918, "Maria");

        System.out.println("----- Object comparison -----");
        System.out.println(getHashCodeMessage(employee1));
        System.out.println(getHashCodeMessage(employee2));
        System.out.println("Comparing objects is true if override the equals() method: " + employee1.equals(employee2));
    }

    public void printHashSetComparison() {
        Employee employeeWithSameId = new Employee(918, "Maria");
        Employee employeeWithDifferentName = new Employee(918, "Maria");

        System.out.println("----- Object comparison in the HashSet -----");
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employeeWithSameId);
        employeeSet.add(employeeWithDifferentName);
        System.out.println("Added objects to HashSet");
        System.out.println("There's only one object in the set if override the equals() and hashCode() methods");
        for (Employee employee : employeeSet) {
            System.out.println(employee);
        }
    }

    private String getHashCodeMessage(Employee employee) {
        return "Hashcode of " + employee + " = " + employee.hashCode();
    }
}