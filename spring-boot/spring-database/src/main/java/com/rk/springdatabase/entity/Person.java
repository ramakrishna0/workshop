package com.rk.springdatabase.entity;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Person {
    private int id;
    private String name;
    private String location;
    private Timestamp birthDate;

}
