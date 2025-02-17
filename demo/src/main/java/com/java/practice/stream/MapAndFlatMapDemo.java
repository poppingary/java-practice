package com.java.practice.stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndFlatMapDemo {
    public static void main(String[] args) {
        IntStream streamOfNumbers = IntStream.rangeClosed(1, 5);
        IntStream squareNumber = streamOfNumbers.map(n -> n * n);
        squareNumber.forEach(System.out::println); // [1, 4, 9, 16, 25]

        Stream<List<Integer>> streamOfLists = Stream.of(
                List.of(1, 2),
                List.of(3, 4, 5),
                List.of(6)
        );

        Stream<Integer> flattenedStream = streamOfLists.flatMap(list -> list.stream());
        flattenedStream.forEach(System.out::println); // [1, 2, 3, 4, 5, 6]
    }
}