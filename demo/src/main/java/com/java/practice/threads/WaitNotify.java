package com.java.practice.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotify {
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    queue.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    queue.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executorService.close();
    }
}

class SharedQueue {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            System.out.println("Waiting to produce data " + value);
            wait();
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait();
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
    }
}