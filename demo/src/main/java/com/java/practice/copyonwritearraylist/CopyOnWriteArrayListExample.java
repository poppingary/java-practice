package com.java.practice.copyonwritearraylist;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        for (String element : list) {
            System.out.println("Element: " + element);

            // CopyOnWriteArrayList is used in multi-threading to keep the array list thread-safe.
            // It will cause a ConcurrentModificationException if using ArrayList
            if (element.equals("Banana")) {
                list.add("Grape");
            }
        }

        System.out.println("Final list: " + list);
    }
}