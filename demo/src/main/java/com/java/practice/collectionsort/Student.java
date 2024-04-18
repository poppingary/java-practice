package com.java.practice.collectionsort;

public class Student implements Comparable<Student> {
    private String name;
    private long id;
    private double score;

    public Student(String name, long id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int sortById = Long.compare(this.id, o.id);
        int sortByName = this.name.compareTo(o.getName());
        int sortByScore = Double.compare(this.score, o.score);

        return sortByScore;
    }
}