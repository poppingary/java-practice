package com.java.practice.stream;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
        List<Integer> listInteger = List.of(1, 2, 3);
        Stream<Integer> listIntegerStream = listInteger.stream();
        listIntegerStream.forEach(System.out::print); // 1, 2, 3
        System.out.println();
        List<String> listString = List.of("apple", "banana", "cherry");
        Stream<String> listStringStream = listString.stream();
        listStringStream.forEach(System.out::print); // apple, banana, cherry

        System.out.println();

        // From Arrays
        Integer[] arrInteger = {1, 2, 3, 4, 5};
        Stream<Integer> arrIntegerStream = Arrays.stream(arrInteger, 1, 4);
        arrIntegerStream.forEach(System.out::print); // 2, 3, 4
        System.out.println();
        String[] arrString = {"apple", "banana", "cherry"};
        Stream<String> arrStringStream = Arrays.stream(arrString, 0, 2);
        arrStringStream.forEach(System.out::print); // apple, banana

        System.out.println();

        // From Values
        Stream<Integer> integerStream = Stream.of(3, 4, 5);
        integerStream.forEach(System.out::print); // 3, 4, 5
        System.out.println();
        Stream<String> stringStream = Stream.of("4", "5", "6");
        stringStream.forEach(System.out::print); // 4, 5, 6

        System.out.println();

        // From Ranges
        IntStream intStream = IntStream.range(5, 8);
        intStream.forEach(System.out::print); // 5, 6, 7
        System.out.println();
        IntStream streamClosed = IntStream.rangeClosed(6, 8);
        streamClosed.forEach(System.out::print); // 6, 7, 8

        System.out.println();

        // From Infinite
        Stream<Integer> stream = Stream.iterate(7, n -> n + 2);
        stream.limit(3).forEach(System.out::print); // 7, 9, 11
        System.out.println();
        Stream<Double> randomStream = Stream.generate(Math::random).map(number -> new BigDecimal(number).setScale(2, RoundingMode.DOWN).doubleValue());
        randomStream.limit(3).forEach(System.out::println); // 0.12, 0.34, 0.56, ...

        // From I/O
        Stream<String> fileStream = Files.lines(Paths.get("/Users/Poppingary/Documents/Java_workspace/products_nio.csv"));
        fileStream.limit(3).forEach(System.out::println); // Print 3 line of the file

        // From Strings
        IntStream charStream = "Hello".chars();
        charStream.forEach(c -> System.out.print((char) c)); // Hello

        System.out.println();

        // From Patterns
        Stream<String> patternStream = Pattern.compile(",").splitAsStream("apple,banana,cherry");
        patternStream.forEach(System.out::print); // apple, banana, cherry
    }
}