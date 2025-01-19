package com.java.practice.threads.race;

public class RaceCondition {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Counter: " + counter.getCount());
    }
}

class Counter {
    private int count = 0;

    // Problem
//    public void increment() {
//        count++;
//    }

    // Solution
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}