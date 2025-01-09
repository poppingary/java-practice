package com.java.practice.threads;

import java.util.concurrent.*;

public class CallableRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Runnable Task
        Runnable runnable = () -> {
            task("Runnable: ");
            try {
                int result = 10 / 0;
                System.out.println("Runnable Task completed.");
            } catch (Exception e) {
                System.out.println("Exception in Runnable: " + e.getMessage());
            }
        };

        // Callable Task
        Callable<String> callable = () -> {
            task("Callable: ");
            int result = 10 / 0;
            return "Callable Task completed";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(runnable);
        Future<String> future = executorService.submit(callable);

        try {
            String result = future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            System.out.println("Exception in Callable: " + e.getCause().getMessage());
        } finally {
            executorService.shutdown();
        }
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