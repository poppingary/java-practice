package com.java.practice.collectionsort;

import java.util.Comparator;

public class ScoreSorter implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getScore(), o2.getScore());
    }
}