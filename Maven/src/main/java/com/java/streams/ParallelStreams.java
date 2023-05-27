package com.java.streams;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        //to create parallel stream
        Stream<String> stream1 = Stream.of("sheep", "goat", "horse").parallel();
//        Stream<String> stream2 = List.of("sheep", "goat", "horse").stream().parallel();
        Stream<String> stream2 = List.of("sheep", "goat", "horse").parallelStream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);

        int sum = Stream.of(10, 20, 30, 40, 50)
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum: " + sum);
    }
}
