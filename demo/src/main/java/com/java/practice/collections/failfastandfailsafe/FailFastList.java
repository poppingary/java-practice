package com.java.practice.collections.failfastandfailsafe;

import java.util.ArrayList;
import java.util.List;

public class FailFastList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));

        for (String s : list) {
            System.out.println(s);
            list.add("d");
        }
    }
}