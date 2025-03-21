package com.java.practice.threads.virtualthread;

import java.util.List;
import java.util.stream.IntStream;

public class MeasureThreadExecutionTime {
    private static final int TOTAL_THREADS = 100_000;
    private static final int SLEEP_DURATION_MS = 100;

    public static void main(String[] args) {
        measureExecutionTime("Platform", TOTAL_THREADS, true);
        System.out.println("--------------------");
        measureExecutionTime("Virtual", TOTAL_THREADS, false);
    }

    private static void measureExecutionTime(String threadType, int totalThreads, boolean isPlatformThread) {
        long startTime = System.currentTimeMillis();

        List<Thread> threads = IntStream.range(0, totalThreads)
                .mapToObj(i -> createThread(isPlatformThread))
                .toList();

        threads.forEach(Thread::start);
        threads.forEach(MeasureThreadExecutionTime::joinThread);

        long endTime = System.currentTimeMillis();
        System.out.printf("Total time for %d %s threads: %d ms%n", totalThreads, threadType, (endTime - startTime));
    }

    private static Thread createThread(boolean isPlatformThread) {
        return isPlatformThread
                ? Thread.ofPlatform().unstarted(MeasureThreadExecutionTime::sleepTask)
                : Thread.ofVirtual().unstarted(MeasureThreadExecutionTime::sleepTask);
    }

    private static void sleepTask() {
        try {
            Thread.sleep(SLEEP_DURATION_MS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}