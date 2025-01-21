package com.java.practice.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // Create a semaphore with 2 permits
        Semaphore semaphore = new Semaphore(2);

        // Create 5 worker threads
        for (int i = 1; i <= 5; i++) {
            Thread worker = new Thread(new Worker(semaphore, "Worker-" + i));
            worker.start();
        }
    }
}

class Worker implements Runnable {
    private Semaphore semaphore;
    private String name;

    public Worker(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + ": Trying to acquire a permit...");
            semaphore.acquire(); // Acquire a permit
            System.out.println(name + ": Permit acquired. Performing work...");
            Thread.sleep(2000);
            System.out.println(name + ": Work done. Releasing permit.");
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception: " + e.getMessage());
        } finally {
            semaphore.release(); // Release the permit
        }
    }
}