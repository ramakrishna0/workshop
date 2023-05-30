package org.example;

import javafx.util.Pair;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] sArray = {"Rama", "Krishna", "Reddy"};
        String joinedString = String.join(" ", sArray);
        System.out.println(joinedString);
        function();

        Person person = new Person();
        System.out.println(person);

        person = new Person(10001, "RK", "IND", Timestamp.from(Instant.now()));
        System.out.println(person);



    }


    public static void function() {
        Pair<Integer, String> pairs = new Pair<>(1, "RK");
        List<Pair<Integer, String >> list = new ArrayList<>();
        list.add(pairs);
        System.out.println(list);
    }
}