package com.java.practice.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FailSafeMap {
    public static void main(String[] args) {
        Map<String, String> failSafeMap = new ConcurrentHashMap<>();

        failSafeMap.put("1", "Java");
        failSafeMap.put("2", "Python");
        failSafeMap.put("3", "C++");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            failSafeMap.put("5", "JavaScript");
        });

        executorService.shutdown();

        for (Map.Entry<String, String> entry : failSafeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            failSafeMap.put("4", "JavaScript");
        }
    }
}