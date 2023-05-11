package com.example.spring.demo.springdemo.cdi;


import org.springframework.stereotype.Component;


@Component
public class SomeCdiDAO {

    public int[] getData() {
        return new int[]{5, 89, 100};
    }
}
