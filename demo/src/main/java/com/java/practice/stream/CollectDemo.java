package com.java.practice.stream;

import com.java.practice.functionalinterface.Person;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.ArrayDeque;

public class CollectDemo {
    public static void main(String[] args) {
        // Collecting to a List
        List<String> list = Stream.of("apple", "banana", "cherry")
                .collect(Collectors.toList());
        System.out.println(list); // Output: [apple, banana, cherry]

        // Collecting to a Set
        Set<String> set = Stream.of("apple", "banana", "apple", "cherry")
                .collect(Collectors.toSet());
        System.out.println(set); // Output (order unspecified): [banana, cherry, apple]

        // Joining Strings
        String joined = Stream.of("A", "B", "C")
                .collect(Collectors.joining(",","[","]"));
        System.out.println(joined); // Output: [A,B,C]

        // Grouping by a key
        List<String> words = List.of("ant", "bear", "cat", "dog", "ape");
        Map<Character, List<String>> grouped = words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(grouped); // Output: {a=[ant, ape], b=[bear], c=[cat], d=[dog]}

        // Partitioning by a predicate
        Map<Boolean, List<Integer>> parts = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(parts); // Output: {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}

        // Creating a custom collector
        Deque<String> deque = Stream.of("one", "two", "three")
                .collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println(deque); // Output: [one, two, three]

        // Mapping before collecting
        List<Person> people = Person.createList();
        Set<String> names = people.stream()
                .map(Person::name)
                .collect(Collectors.toSet());
        System.out.println(names); // Output: [Curry, Lebron, Betty, John, Durant, Phil]
    }
}