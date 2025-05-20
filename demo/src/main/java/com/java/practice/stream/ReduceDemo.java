package com.java.practice.stream;

import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(numbers.stream()
                .reduce(0, Integer::sum)); // 15

        System.out.println(numbers.stream()
                .reduce(1, (a, b) -> a * b)); // 120

        System.out.println(numbers.stream()
                .reduce(Integer::max)
                .orElse(0)); // 5

        System.out.println(numbers.stream()
                .reduce(Integer::min)
                .orElse(0)); // 1

        List<String> words = List.of("Hello", " ", "World", "!");
        System.out.println(words.stream()
                .reduce("", (s1, s2) -> s1 + s2)); // Hello World!

        System.out.println(words.stream()
                .reduce(
                        "",
                        (s1, s2) -> s1.isEmpty() ? s2 : s1 + "," + s2
                )); // Hello, ,World,!

        System.out.println(words.stream()
                .reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2)
                .orElse("")); // Hello
    }
}