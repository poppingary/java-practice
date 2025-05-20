package com.java.practice.stream;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamDemo {
    public static void main(String[] args) throws IOException {
        // From Collections
        List<Integer> list = List.of(1, 2, 3);
        String outputList = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(outputList); // 1, 2, 3

        // From Arrays
        Integer[] arr = {1, 2, 3, 4, 5};
        String outputArr = Arrays.stream(arr, 1, 4)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(outputArr); // 2, 3, 4

        // From Values
        String outputValues = Stream.of(3, 4, 5)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(outputValues); // 3, 4, 5

        // From Ranges
        String outputRange = IntStream.range(4, 7)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(outputRange); // 4, 5, 6

        String outputRangeClosed = IntStream.rangeClosed(4, 7)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(outputRangeClosed); // 4, 5, 6, 7

        // From Infinite
        String outputInfinite = Stream.iterate(5, n -> n + 2)
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(outputInfinite); // 5, 7, 9

        String outputRandom = Stream.generate(Math::random)
                .map(number -> new BigDecimal(number).setScale(2, RoundingMode.DOWN).toString())
                .limit(3)
                .collect(Collectors.joining(", "));
        System.out.println(outputRandom); // 0.xx, 0.xx, 0.xx

        // From I/O
        try (Stream<String> fileStream = Files.lines(Paths.get("/Users/Poppingary/Documents/Java_workspace/products_nio.csv"))) {
            String outputFile = fileStream.limit(3).collect(Collectors.joining("\n"));
            System.out.println(outputFile);
            // First three lines of the file (separated by newlines)
        }

        // From Strings
        String outputChars = "Hello".chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining(", "));
        System.out.println(outputChars); // H, e, l, l, o

        // From Patterns
        String outputPattern = Pattern.compile(",")
                .splitAsStream("apple,banana,cherry")
                .collect(Collectors.joining(", "));
        System.out.println(outputPattern); // apple, banana, cherry
    }
}