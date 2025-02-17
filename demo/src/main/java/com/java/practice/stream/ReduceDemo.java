package com.java.practice.stream;

import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        Stream<Integer> nums = Stream.of(1, 2, 3, 4, 5);
        int sum = nums.reduce(0, Integer::sum);
        System.out.println(sum); // 15

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        int product = numbers.reduce(1, (a, b) -> a * b);
        System.out.println(product); // 120
    }
}