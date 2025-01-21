package com.java.practice.collections.failfastandfailsafe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeMap {
    public static void main(String[] args) {
        Map<String, String> failSafeMap = new ConcurrentHashMap<>();

        failSafeMap.put("1", "Java");
        failSafeMap.put("2", "Python");
        failSafeMap.put("3", "C++");

        for (Map.Entry<String, String> entry : failSafeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            failSafeMap.put("4", "JavaScript");
        }
    }
}