package com.rk.springdatabase.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Person {
    private int id;
    private String name;
    private String location;
    private Date birthDate;

}
