package com.java.streams;

import org.example.Person;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        filterOperation();
        distinctOperation();
        limitOperation();
        mapOperation();
        flatMapOperation();
        sortedOperation();
    }

    public static void filterOperation() {
        Stream.of("galway", "mayo", "roscommon")
                .filter(s -> s.length() > 5)
                .forEach(System.out::println);
    }
    public static void distinctOperation() {
        Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Peter")
                .peek(s -> System.out.println("1. " + s))
                .distinct()
                .forEach(s -> System.out.println("2. " + s));

    }
    public static void limitOperation() {
        Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Peter")
                .limit(3)
                .forEach(System.out::println);
    }

    public static void mapOperation() {
        //used to create 1-1 mapping between elements of stream to
        //                                   elements in the next stage of stream
        //map to used to transform data
        // <R> Stream<R> map(Function<T, R> mapper);
        Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Peter")
                .map(String::length)
                .forEach(System.out::println);
    }

    public static void flatMapOperation() {
        List<String> list1 = List.of("Peter", "Parker");
        List<String> list2 = List.of("Uncle", "Ben");
        Stream.of(list1, list2)
                .flatMap(list -> list.stream())
                .forEach(System.out::println);
        Stream.of(list1, list2)
                .map(Collection::stream)
//                .Map(list -> list.stream())
                .forEach(System.out::println);
    }
    public static void sortedOperation() {
        //<T> Stream<T> sorted(? Function keyMapper, ? Comparator comparator);
        Person john = new Person(1, "John");
        Person doe = new Person(2, "Doe");
        Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Peter")
                .sorted()
                .forEach(System.out::println);
        Stream.of(john, doe)
//                .sorted(Comparator.comparing(Person::getId))
                .sorted(
                        Comparator.comparing( Person::getId, Comparator.reverseOrder() )
                )
                .forEach(System.out::println);
    }
}
