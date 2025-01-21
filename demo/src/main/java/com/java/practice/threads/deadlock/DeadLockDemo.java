package com.java.practice.threads.deadlock;

public class DeadLockDemo {
    private final Object resource1 = new Object();
    private final Object resource2 = new Object();

    public void thread1() {
        synchronized (resource1) {
            System.out.println("Thread 1: Locked resource 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource2) {
                System.out.println("Thread 1: Locked resource 2");
            }
        }
    }

    public void thread2() {
        synchronized (resource2) {
            System.out.println("Thread 2: Locked resource 2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resource1) {
                System.out.println("Thread 2: Locked resource 1");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockDemo example = new DeadLockDemo();

        Thread t1 = new Thread(example::thread1);
        Thread t2 = new Thread(example::thread2);

        t1.start();
        t2.start();
    }
}