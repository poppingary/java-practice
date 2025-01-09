package com.java.practice.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThread {
    static class MyThread extends Thread {
        public void run() {
            task("Thread (Extends Thread): ");
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            task("Thread (Implements Runnable): ");
        }
    }

    public static void main(String[] args) {
        // 1. Using Extending Thread
        MyThread myThread = new MyThread();
        myThread.start();

        // 2. Using Implementing Runnable
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

        // 3. Using Lambda Expression
        Thread myRunnableLambda = new Thread(() -> task("Thread (Lambda): "));
        myRunnableLambda.start();

        // 4. Using Executor Framework
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> task("Thread (ExecutorService Task 1): "));
        executorService.submit(() -> task("Thread (ExecutorService Task 2): "));

        executorService.shutdown();
    }

    private static void task(String x) {
        for (int i = 0; i < 3; i++) {
            System.out.println(x + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}