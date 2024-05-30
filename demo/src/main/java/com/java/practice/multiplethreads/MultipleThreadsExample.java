package com.java.practice.multiplethreads;

public class MultipleThreadsExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        IncrementThread incrementThread = new IncrementThread(counter);
        DecrementThread decrementThread = new DecrementThread(counter);

        incrementThread.start();
        Thread decrement = new Thread(decrementThread);
        decrement.start();

        // Wait for increment threads to finish
        try {
            decrement.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}