package com.java.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
        minMax();
        reduce();
        reduceByCollect();
        collectToMap();
        groupingBy();
        partitioningBy();
    }

    private static void minMax() {
        Optional<String> min = Stream.of("deer", "horse", "pig")
                .min(Comparator.comparingInt(String::length));
//                .min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        Optional<Integer> max = Stream.of(5, 4, 6, 2, 12, 9)
                .max(Comparator.naturalOrder());
//                .max((n1, n2) -> n1 - n2);
        max.ifPresent(System.out::println);

    }

    private static void reduce() {
        //<T> T reduce(T identity, BinaryOperator<T> accumulator)
        String name = Stream.of("R", "a", "m", "a")
                .reduce("Mr. ", String::concat);
//                .reduce("Mr. ", (a, b) -> a + b);
        System.out.println(name);
        Integer product = Stream.of(2, 3, 4)
                .reduce(1, Math::multiplyExact);
//                .reduce(1, (a, b) -> a * b);
        System.out.println(product);


        int length = Stream.of("Car", "Bus", "Train", "Aeroplane")
                .reduce(0,
                        (n, str) -> n + str.length(),
                        Integer::sum
//                        (n1, n2) -> n1 + n2
                );
// <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)
        /*
        In its more general form, a reduce operation on elements of type <T> yielding a result of type <U> requires three parameters:
 <U> U reduce(U identity,               BiFunction<U, ? super T, U> accumulator,               BinaryOperator<U> combiner);
Here, the identity element is both an initial seed value for the reduction and a default result if there are no input elements. The accumulator function takes a partial result and the next element, and produces a new partial result. The combiner function combines two partial results to produce a new partial result. (The combiner is necessary in parallel reductions, where the input is partitioned, a partial accumulation computed for each partition, and then the partial results are combined to produce a final result.)
More formally, the identity value must be an identity for the combiner function. This means that for all u, combiner.apply(identity, u) is equal to u. Additionally, the combiner function must be associative and must be compatible with the accumulator function: for all u and t, combiner.apply(u, accumulator.apply(identity, t)) must be equals() to accumulator.apply(u, t).
The three-argument form is a generalization of the two-argument form, incorporating a mapping step into the accumulation step. We could re-cast the simple sum-of-weights example using the more general form as follows:
 int sumOfWeights = widgets.stream()                            .reduce(0,                                    (sum, b) -> sum + b.getWeight(),                                    Integer::sum);
though the explicit map-reduce form is more readable and therefore should usually be preferred. The generalized form is provided for cases where significant work can be optimized away by combining mapping and reducing into a single function.
       */
        System.out.println(length);
    }

    private static void reduceByCollect() {
        // U return type, T is stream type
        //<U> U collect(Supplier<U> supplier, BiConsumer(U, T) accumulator, BiConsumer(U, U) combiner)
        StringBuilder word = Stream.of("Ad", "Blo", "ck", "er")
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                );
                /*.collect(
                        () -> new StringBuilder(),
                        (sb, str) -> sb.append(str),
                        (sb1, sb2) -> sb1.append(sb2)
                );*/
        System.out.println(word);
        List<String> strings = Stream.of("Ad", "Blo", "ck", "er")
                .toList();  // since java 16
//                .collect(Collectors.toList());
        System.out.println(strings);
        String s = Stream.of("Ad", "Blo", "ck", "er")
                .collect(Collectors.joining(", "));
//                .collect(Collectors.joining());   //Adblocker
        System.out.println(s);
        Double avg = Stream.of("Ad", "Blo", "ck", "er")
                .collect(Collectors.averagingInt(String::length));
//                .collect(Collectors.averagingInt(s -> s.length()));
        // averagingInt(ToIntFunction);    ToIntFunction ---> int applyAsInt(T value);
        System.out.println(avg);
    }

    public static void collectToMap() {
        //Map<K,V> Collectors<T>.toMap(Function<T,K> keyMapper, Function<T,V> valueMapper, ? BinaryOperator<V> mergeFunction to handle duplicate keys)
        Map<String, Integer> map = Stream.of("Cake", "Biscuits", "Apple Tart")
                .collect(Collectors.toMap(
                        s -> s,                 //keyMapper
                        String::length          //valueMapper
                ));
        System.out.println(map);
        Map<Integer, String> map2 = Stream.of("Biscuits", "Tart", "Cake")
                .collect(Collectors.toMap(
                        String::length,
                        s -> s,
                        String::concat,         //mergeFunction to handle duplicate keys
                        TreeMap::new            //default return type is HashMap, to change it pass required Map
                ));
        //map2 throws run time error --> Duplicate key if there's no merge function
        //mergeFunction -  BinaryOperator<V>
        System.out.println(map2);
        System.out.println(map2.getClass().getName());
    }

    public static void groupingBy() {
        Map<Integer, List<String>> map = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Parker")
                .collect(
                        Collectors.groupingBy(String::length)
                );
        System.out.println(map);
        //Map<K, List<V> Collectors.groupingBy(Function<T, K> keyMapper, ? Supplier mapSupplier, downStream);
        TreeMap<Integer, Set<String>> map2 = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Parker")
                .collect(Collectors.groupingBy(
                                String::length,         //keyMapper --> required
                                TreeMap::new,           //mapSupplier --> default HashMap
                                Collectors.toSet()      //downStream --> default List
                        ));

    }

    public static void partitioningBy() {
        // Map<Boolean, List<V> Collectors.groupingBy(Predicate<Boolean, K> keyMapper, downStream);
        Map<Boolean, Set<String>> map = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter", "Parker")
                .collect(Collectors.partitioningBy(
                        s -> s.startsWith("T"),          //predicate function
                        Collectors.toSet()              //downStream --> default List
                ));
        System.out.println(map);
    }
}
