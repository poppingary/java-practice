package com.java.practice.collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeList {
    public static void main(String[] args) {
        List<String> failSafeList = new CopyOnWriteArrayList<>();

        failSafeList.add("Java");
        failSafeList.add("Python");
        failSafeList.add("C++");

        for (String language : failSafeList) {
            System.out.println(language);
            failSafeList.add("JavaScript");
        }
    }
}