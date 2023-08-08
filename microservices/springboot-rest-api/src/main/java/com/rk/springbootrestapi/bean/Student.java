package com.rk.springbootrestapi.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter @ToString
public class Student {
    private int id;
    private String firstName;
    private String lastName;
}
