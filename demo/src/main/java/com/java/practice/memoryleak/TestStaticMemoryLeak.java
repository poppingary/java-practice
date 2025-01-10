package com.java.practice.memoryleak;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TestStaticMemoryLeak {
    public static List<Double> staticList = new ArrayList<>();
    public List<Double> list = new ArrayList<>();

    private void createStaticList() {
        IntStream.range(0, 10000000)
                .mapToObj(i -> Math.random())
                .forEach(staticList::add);
    }

    private void createList() {
        IntStream.range(0, 10000000)
                .mapToObj(i -> Math.random())
                .forEach(list::add);
    }

    private void clearMemory() {
        // Clear instance list
        if (list != null) {
            list.clear();
            list = null;
        }

        // Clear static list
        if (staticList != null) {
            staticList.clear();
            staticList = null;
        }
    }

    public static void main(String[] args) {
        TestStaticMemoryLeak testStaticMemoryLeak = new TestStaticMemoryLeak();

        System.out.println("Checking point 1");
        testStaticMemoryLeak.createStaticList();

        System.out.println("Checking point 2");
        testStaticMemoryLeak.createList();

        System.out.println("Checking point 3");
        testStaticMemoryLeak.clearMemory();
        System.gc();

        System.out.println("Checking point 4");
    }
}