package com.java.practice.threads.racecondition;

public class RaceConditionDemo {
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
    private volatile int count = 0;

    // Problem
//    public void increment() {
//        count++;
//    }

    // Solution 1 - volatile keyword to count variable
    public void increment() {
        count++;
    }

    // Solution 2 - synchronized method
//    public synchronized void increment() {
//        count++;
//    }

    public int getCount() {
        return count;
    }
}