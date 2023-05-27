package org.example;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private int id;
    private String name;
    private String location;
    private Timestamp birthDate;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}