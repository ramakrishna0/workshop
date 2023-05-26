package com.java.streams;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamFile {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("D:\\git\\ramakrishna\\Maven\\src\\main\\resources\\Cats.txt"))) {
            stream.forEach(line -> {
                String[] catsArray = line.split("/");
                cats.add(new Cat(catsArray[0], catsArray[1]));
            });

        } catch (IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        System.out.println(cats);
    }
}

@AllArgsConstructor
@ToString
class Cat {
    private String name;
    private String color;
}