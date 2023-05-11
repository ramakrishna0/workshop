package org.example;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] sArray = {"Rama", "Krishna", "Reddy"};
        String joinedString = String.join(" ", sArray);


        System.out.println(joinedString);
        function();


    }


    public static void function() {
        Pair<Integer, String> pairs = new Pair<>(1, "RK");
        List<Pair<Integer, String >> list = new ArrayList<>();
        list.add(pairs);
        System.out.println(list);
    }
}