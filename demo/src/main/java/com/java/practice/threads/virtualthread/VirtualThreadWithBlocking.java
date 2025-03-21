package com.java.practice.threads.virtualthread;

import java.util.stream.IntStream;

public class VirtualThreadWithBlocking {
    public static void main(String[] args) {
        var threads = IntStream.range(0, 5)
                .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
                    System.out.println("Start - Virtual thread " + i + ": " + Thread.currentThread());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("End - Virtual thread " + i + ": " + Thread.currentThread());
                })).toList();
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}