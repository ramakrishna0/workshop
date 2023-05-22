package com.java.functional.interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        boundMethodReference();
        unboundMethodRefernce();
        staticMethodReference();
        constructorMethodReference();
        contextExample();
    }

    public static void constructorMethodReference() {
//        Supplier<StringBuilder> sbL = () -> new StringBuilder();
        Supplier<StringBuilder> sbMR = StringBuilder::new;
        System.out.println(sbMR.get().append("constructor method reference"));
//        Function<Integer, AtomicInteger> aiL = (i) -> new AtomicInteger();
        Function<Integer, AtomicInteger> aiMR = AtomicInteger::new;
        AtomicInteger ai = aiMR.apply(5);
        System.out.println(ai.get() + 2);
        System.out.println(ai.getClass().getName());
    }

    public static void staticMethodReference() {
        //
//        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;
        //here Collections.sort(List) is used instead of Collections.sort(List, Comparator)
        //because consumer has <T> void accept(T t);
//        List<Integer> l = List.of(2,1,5,3,4);
        //exception: java.lang.UnsupportedOperationException - ImmutableCollections$AbstractImmutableList.sort
        List<Integer> l = Arrays.asList(2,1,5,3,4);
        sortMR.accept(l);

        System.out.println(l);
    }

    public static void unboundMethodRefernce() {
//        Function<String, String> upperL = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;
        System.out.println(upperMR.apply("Any String"));
//        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;
        System.out.println(concatMR.apply("R", "K"));
        //here we need to specify which instances on which want to run Function and BiFunction
    }

    public static void boundMethodReference() {
        String name = "Mr. John Doe";
//        Supplier<String> lowerL = () -> name.toLowerCase();
        Supplier<String> lowerMR = name::toLowerCase;
        //supplier is bound to name
        System.out.println(lowerMR.get());
//        Predicate<String> titleL = title -> name.startsWith(title);
        //string has startsWith(String) and startsWith(string, int)
        //compiler decides to use startsWith(String)
        //because predicate has <T> boolean test(T t);   -->CONTEXT is important
        //predicate is still bound to name regardless of the condition
        Predicate<String> titleMR = name::startsWith;
        System.out.println(titleMR.test("Mr."));
    }

    public static void contextExample() {
        //Person::howMany; will overload depending on type FI based upon its declaration
//        Supplier<Integer> l1 = () -> Person.howMany();
        Supplier<Integer> mr1 = Person::howMany;
//        Function<Person, Integer> l2 = person -> Person.howMany(person);
        Function<Person, Integer> mr2 = Person::howMany;
//        BiFunction<Person, Person, Integer> l3 = (person1, person2) -> Person.howMany(person1, person2);
        BiFunction<Person, Person, Integer> mr3 = Person::howMany;
        System.out.println(mr1.get());
        System.out.println(mr2.apply(new Person()));
        System.out.println(mr3.apply(new Person(), new Person()));
    }

}

class Person {
    public static Integer howMany(Person... people) {
        return people.length;
    }
}