package com.java.practice.stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndFlatMapDemo {
    public static void main(String[] args) {
        List<Integer> squareNumber = IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(squareNumber); // [1, 4, 9, 16, 25]

        Stream<List<Integer>> streamOfLists = Stream.of(
                List.of(1, 2),
                List.of(3, 4, 5),
                List.of(6)
        );

        List<Integer> flattenedList = streamOfLists
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList); // [1, 2, 3, 4, 5, 6]
    }
}