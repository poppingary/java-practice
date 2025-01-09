package com.java.practice.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateThread {
    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread (Extends Thread): " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread (Implements Runnable): " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
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
        Thread myRunnableLambda = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread (Lambda): " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        myRunnableLambda.start();

        // 4. Using Executor Framework
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread (ExecutorService Task 1): " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        executorService.submit(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread (ExecutorService Task 2): " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executorService.shutdown();
    }
}