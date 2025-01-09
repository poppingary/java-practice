package com.java.practice.threads;

import java.util.concurrent.*;

public class FutureCompletableFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // ===== Future Example =====
        System.out.println("=== Future Example ===");
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Future Task: Calculating sum...");
            Thread.sleep(2000);
            return 10 + 20;
        });

        System.out.println("Main thread (Future) is free to do other work...");

        try {
            // Blocking call to get the result
            Integer futureResult = future.get();
            System.out.println("Result from Future: " + futureResult);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error in Future: " + e.getMessage());
        }

        // ===== CompletableFuture Example =====
        System.out.println("\n=== CompletableFuture Example ===");
        CompletableFuture.supplyAsync(() -> {
            System.out.println("CompletableFuture Task: Calculating sum...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 10 + 20;
        }).thenApply(result -> {
            System.out.println("Transforming Result: Doubling the sum...");
            return result * 2;
        }).thenAccept(finalResult -> {
            System.out.println("Final Result from CompletableFuture: " + finalResult);
        }).exceptionally(ex -> {
            System.out.println("Error in CompletableFuture: " + ex.getMessage());
            return null;
        });

        System.out.println("Main thread (CompletableFuture) is free to do other work...");

        // Pause to ensure async tasks complete before program exits
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        executor.shutdown();
    }
}