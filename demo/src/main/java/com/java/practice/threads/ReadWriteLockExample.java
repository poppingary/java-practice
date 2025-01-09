package com.java.practice.threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int sharedData = 0;

    // Read Method - Can be accessed by multiple threads concurrently
    public void read() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading data: " + sharedData);
        } finally {
            lock.readLock().unlock();
        }
    }

    // Write Method - Can only be accessed by one thread at a time
    public void write(int value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing data: " + value);
            sharedData = value;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();

        // Multiple threads reading concurrently
        Runnable readTask = () -> {
            for (int i = 0; i < 5; i++) {
                example.read();
            }
        };

        // One thread writing while others are reading
        Runnable writeTask = () -> example.write(42);

        Thread reader1 = new Thread(readTask, "Reader 1");
        Thread reader2 = new Thread(readTask, "Reader 2");
        Thread writer = new Thread(writeTask, "Writer");

        reader1.start();
        reader2.start();
        writer.start();

        try {
            reader1.join();
            reader2.join();
            writer.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}