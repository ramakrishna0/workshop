package com.java.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(98, 101, 88, 102);
        long count = numbers.stream()
                .peek(System.out::println)
                .filter(n -> n > 100)
                .peek(System.out::println)
                .count();
        System.out.println(count);

        List<String> list = List.of("Alex", "David", "April", "Edward");

        list.stream()
                .filter(s -> {
                    System.out.println("filter: " +s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

        boolean anyMatch = list.stream()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("D");
                });
        System.out.println(anyMatch);

        Stream.of("April", "Ben", "Charlie", "David", "Benildus", "Christian")
                .peek(System.out::println)
                .filter(s -> {
                    System.out.println("filter1: " + s);
                    return s.startsWith("B") || s.startsWith("C");
                })
                .filter(s -> {
                    System.out.println("filter2: " + s);
                    return s.length() > 3;
                })
                .limit(1)
                .forEach(System.out::println);

        Map<String, Integer> map = new HashMap<>();
        map.put("RK", 27);
        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();
        long entries = map.entrySet()
                .stream()
                .peek(System.out::println)
                .count();
        System.out.println(entries);
    }

}

