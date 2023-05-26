package com.java.streams;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);
        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L);
//        System.out.println(intStream.count() + "\n" + doubleStream.count() + "\n" + longStream.count());
//        System.out.println(intStream.reduce(0, Integer::sum));
        // reduce(identity, binaryOperatorAccumulator)
        //sum() average() min() max()
        System.out.println(intStream.sum());
        //converting Stream<T> to Intstream using mapToInt ---> called as unboxed
        int total = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(n -> n)
//                .mapToDouble(n -> n)      //to convert to double stream
                .sum();
        OptionalDouble average = doubleStream.average();
        OptionalLong min = longStream.min();
        System.out.println(min.orElse(0L));
        System.out.println(average);
        System.out.println(total);

        summaryStats();
        mapToPrimitve();
        howToDealWithNullValues("RK");
        howToDealWithNullValues(null);

//        Optional<Double> optDouble = optionalCalcAverage(1,2,3,4,5);
        OptionalDouble optDouble = optionalCalcAverage(1,2,3,4,5);
        System.out.println(optDouble);
        optDouble.ifPresent(System.out::println);
        optDouble = optionalCalcAverage();
        optDouble.ifPresentOrElse(
                System.out::println,
                () -> System.out.println(Double.NaN)
        );
        /*if (optDouble.isPresent())
            System.out.println(optDouble.get());
        else
            System.out.println(Double.NaN);*/


    }

    public static void summaryStats() {
        IntSummaryStatistics summaryStatistics = IntStream.of(1, 2, 3, 4, 5).summaryStatistics();
        System.out.println(summaryStatistics);
        System.out.println(summaryStatistics.getMax());
    }

    public static void mapToPrimitve() {
        ToDoubleFunction<String> toDoubleFunction = String::length;

        Stream.of("ash", "beech", "sycamore")
                .map(String::toUpperCase)
                .forEach(System.out::println);
        Stream.of("ash", "beech", "sycamore")
//                .mapToDouble(String::length)        //upcast to double, same happens for mapToLong -> upcast to Long
                .mapToDouble(toDoubleFunction)
                .forEach(System.out::println);
        Stream.of("ash", "beech", "sycamore")
                .mapToInt(String::length)
                .forEach(System.out::println);

        IntStream.of(1, 2, 3, 4, 5)
//                .mapToObj(Integer::valueOf)
                .boxed()
                .forEach(System.out::println);
    }

//    public static Optional<Double> optionalCalcAverage(int... values) {
    public static OptionalDouble optionalCalcAverage(int... values) {
        if (values.length == 0)
            return OptionalDouble.empty();
        int sum = 0;
        for (int value : values)
            sum += value;
        return OptionalDouble.of((double)sum/values.length);
    }

    public static void howToDealWithNullValues(String param) {
//        Optional<String> optParams = param == null ? Optional.empty() : Optional.of(param);
        Optional<String> optParam = Optional.ofNullable(param);
        optParam.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Empty params")
        );
    }


}
