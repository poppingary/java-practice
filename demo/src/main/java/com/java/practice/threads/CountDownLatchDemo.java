package com.java.practice.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        // CountDownLatch with count 3
        CountDownLatch latch = new CountDownLatch(3);

        // Worker threads
        Thread worker1 = new Thread(() -> {
            try {
                System.out.println("Worker 1 is doing its job...");
                Thread.sleep(1000); // Simulate work
                System.out.println("Worker 1 completed.");
                latch.countDown(); // Decrement the latch count
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread worker2 = new Thread(() -> {
            try {
                System.out.println("Worker 2 is doing its job...");
                Thread.sleep(2000); // Simulate work
                System.out.println("Worker 2 completed.");
                latch.countDown(); // Decrement the latch count
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread worker3 = new Thread(() -> {
            try {
                System.out.println("Worker 3 is doing its job...");
                Thread.sleep(3000); // Simulate work
                System.out.println("Worker 3 completed.");
                latch.countDown(); // Decrement the latch count
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start workers
        worker1.start();
        worker2.start();
        worker3.start();

        // Main thread waits for workers to finish
        try {
            System.out.println("Main thread waiting for workers to finish...");
            latch.await(); // Wait until latch count reaches 0
            System.out.println("All workers completed. Main thread resumes.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}