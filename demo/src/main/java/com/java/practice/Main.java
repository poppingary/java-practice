package com.java.practice;

import com.java.practice.collectionsort.StudentSorter;
import com.java.practice.objectequality.Comparison;

public class Main {
    public static void main(String[] args) {
        StudentSorter studentSorter = new StudentSorter();
        studentSorter.sort();

        Comparison comparison = new Comparison();
        comparison.printObjectComparison();
        comparison.printHashSetComparison();
    }
}