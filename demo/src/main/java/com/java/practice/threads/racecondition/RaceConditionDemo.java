package com.java.practice.threads.racecondition;

import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionDemo {
    public static void main(String[] args) {
        lockSolution();
        synchronizedSolution();
    }

    private static void lockSolution() {
        LocksCounter locksCounter = new LocksCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                locksCounter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                locksCounter.increment();
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

        System.out.println("Locks Counter: " + locksCounter.getCount());
    }

    private static void synchronizedSolution() {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedCounter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedCounter.increment();
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

        System.out.println("Synchronized Counter: " + synchronizedCounter.getCount());
    }
}

// Locks method
class LocksCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public synchronized void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++; // Critical section
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public int getCount() {
        return count;
    }
}

// Synchronized method
class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}