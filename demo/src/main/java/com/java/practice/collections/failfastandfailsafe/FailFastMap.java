package com.java.practice.collections.failfastandfailsafe;

import java.util.HashMap;
import java.util.Map;

public class FailFastMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "apple");
        map.put("b", "banana");
        map.put("c", "cherry");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            map.put("d", "date");
        }
    }
}