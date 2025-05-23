package com.java.practice.stream;

import com.java.practice.functionalinterface.Person;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonlyUsedDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> words = List.of("apple", "banana", "cherry");

        // Filter Elements
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        // Map (Transform) Elements
        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .toList();

        // Sort Elements
        List<String> sorted = words.stream()
                .sorted()
                .toList();

        // Reduce (Sum, Max, Min)
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        // Collect to Map
        Map<String, Integer> map = words.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length));

        // Group by Field
        Map<Integer, List<Person>> grouped = Person.createList().stream()
                .collect(Collectors.groupingBy(Person::age));

        // Partition by Predicate
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        // Join Strings
        String joined = String.join(",", words);

        // Distinct Elements
        List<String> unique = words.stream()
                .distinct()
                .toList();

        // FlatMap for Nested Collections
        List<List<Integer>> nested = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .toList();
    }
}