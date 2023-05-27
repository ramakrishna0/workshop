package com.java.functional.interfaces;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

interface Evaluate<T> {
    boolean isNegative(T t);
}

public class FI_from_API {
    public static void main(String[] args) throws InterruptedException {
        //old way
        Evaluate<Integer> lambda = new Evaluate<Integer>() {
            @Override
            public boolean isNegative(Integer integer) {
                return integer < 0;
            }
        };
        System.out.println(lambda.isNegative(5));
        //new way - 1
        Evaluate<Integer> lambda1 = (i) -> {
            return i < 0;
        };
        System.out.println(lambda1.isNegative(5));
        //new way - 2
        Evaluate<Integer> lambda2 = i -> i < 0;
        System.out.println(lambda2.isNegative(5));

        predicate();
        supplier();
        consumer();
        function();
        uniaryBinaryOperator();

    }

    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }

    public static void predicate() {
        //Predicate<T> is a functional interface in java.util.function package with method boolean test(t t);
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println(predicate.test(5));
        int x = 4;
        System.out.println("Even check 4 - " + check(x, n -> n%2 == 0));
        x = 7;
        System.out.println("Even check 7 - " + check(x, n -> n%2 == 0));
        System.out.println("isNegative check - " + check(x, predicate));
        //BiPredicate<K, V> is functional interface with method boolean test(K k,V v);
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("RK", 2));
    }

    public static void supplier() {
        //Supplier<T> FI -> T get();
//        Supplier<LocalTime> sTime = () -> LocalTime.now();
        Supplier<LocalTime> sTime = LocalTime::now;  // lambda method reference
        System.out.println("Supplier time: " + sTime.get());
//        Supplier<StringBuilder> sSB = () -> new StringBuilder();
        Supplier<StringBuilder> sSB = StringBuilder::new;
        System.out.println("supplier sb :" + sSB.get().append("RK"));
        Supplier<Double> sRandom = Math::random;
        System.out.println(sRandom.get());
        System.out.println(sRandom.get());
        System.out.println(sRandom.get());
        System.out.println("Supplier time: " + sTime.get());
    }

    private static void consumer() {
        //Consumer<T> - FI - void accept(T t);
//        Consumer<String> printS = s -> System.out.println(s);
        Consumer<String> printS = System.out::println;
        printS.accept("Hello World");

        List<String> names = List.of("Rama", "Krishna");
        names.forEach(printS);
//        names.forEach(s -> printS.accept(s));
//        names.forEach(printS::accept);

        Map<String, String> mapCapitals = new HashMap<>();
        //BiConsumer<T, U> - FI - void accept(T t, U u);
        BiConsumer<String, String> biCon = mapCapitals::put;
//        BiConsumer<String, String> biCon = (key, value) -> mapCapitals.put(key, value);
        biCon.accept("Delhi", "India");
        biCon.accept("Washington D.C", "USA");
        System.out.println(mapCapitals);
        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital city of " + value);
        mapCapitals.forEach(mapPrint);
    }

    private static void function() {
        //Function<T, R> - FI - R apply (T t);
//        Function<String, Integer> fn = s -> s.length();
        Function<String, Integer> fn1 = String::length;
        System.out.println("Function: " + fn1.apply("Rama"));

        //BiFunction<T, U, R> - FI - R apply(T t, U u);
        BiFunction<String, String, Integer> biFn1 = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn1.apply("Rama", "Krishna"));
//        BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> biFn2 = String::concat;
        System.out.println("BiFunction: " + biFn2.apply("Rama", "Krishna"));
        int x = 12;
        Function<Integer, Integer> fn2 = i -> i+x;
        System.out.println(fn2.apply(4));
        System.out.println(fn2.apply(4));
    }

    public static void uniaryBinaryOperator() {
        //UnaryOperator<T> - FI - T apply(T t); -> derivative of Function
        UnaryOperator<String> unaryOp = s -> "My name is: " + s;
        List<String> names = List.of("Rama", "Krishna");
        names.forEach(name -> System.out.println(unaryOp.apply(name)));

        //BinaryOperator<T> - FI - T apply(T t, T u); -> derivative of BiFunction
        BinaryOperator<String> binaryOp = String::concat;
        System.out.println("BinaryOperator: " + binaryOp.apply("Rama", "Krishna"));
    }

}
