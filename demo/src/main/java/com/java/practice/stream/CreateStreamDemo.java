package com.java.practice.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) throws IOException {
        // From Collections
        List<Integer> listInteger = List.of(1, 2, 3, 4, 5);
        List<String> listString = List.of("apple", "banana", "cherry");
        Stream<Integer> listIntegerStream = listInteger.stream();
        Stream<String> listStringStream = listString.stream();

        // From Arrays
        Integer[] arrInteger = {1, 2, 3, 4, 5};
        String[] arrString = {"apple", "banana", "cherry"};
        Stream<Integer> arrIntegerStream = Arrays.stream(arrInteger);
        Stream<String> arrStringStream = Arrays.stream(arrString);

        // From Values
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stringStream = Stream.of("1", "2", "3", "4", "5");

        // From Ranges
        IntStream intStream = IntStream.range(1, 5); // 1, 2, 3, 4
        IntStream streamClosed = IntStream.rangeClosed(1, 5); // 1, 2, 3, 4, 5

        // From Infinite
        Stream<Integer> stream = Stream.iterate(1, n -> n + 1); // 1, 2, 3, 4, ...
        Stream<Double> randomStream = Stream.generate(Math::random); // 0.123, 0.456, 0.789, ...

        // From Files
        Stream<String> fileStream = Files.lines(Paths.get("/Users/Poppingary/Documents/Java_workspace/products_nio.csv"));

        // From Strings
        IntStream charStream = "Hello".chars(); // 72, 101, 108, 108, 111

        // From Patterns
        Stream<String> patternStream = Pattern.compile(",").splitAsStream("apple,banana,cherry");
    }
}