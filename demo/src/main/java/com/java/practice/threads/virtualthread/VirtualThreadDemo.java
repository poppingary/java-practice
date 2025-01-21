package com.java.practice.threads.virtualthread;

import java.util.concurrent.CountDownLatch;

public class VirtualThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        Thread.ofPlatform().start(() -> {
            System.out.println("Platform thread: " + Thread.currentThread());
            latch.countDown();
        });

        Thread.ofVirtual().start(() -> {
            System.out.println("Virtual thread: " + Thread.currentThread());
            latch.countDown();
        });

        latch.await(); // Wait for both threads to finish
    }
}