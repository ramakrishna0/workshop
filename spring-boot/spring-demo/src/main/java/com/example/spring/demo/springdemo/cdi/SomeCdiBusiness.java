package com.example.spring.demo.springdemo.cdi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter @Getter
public class SomeCdiBusiness {

    @Autowired
    SomeCdiDAO someCdiDAO;


    public int findGreatest() {
        int[] data = someCdiDAO.getData();
        int greatest = Integer.MIN_VALUE;
        for (int value : data) {
            greatest = Math.max(greatest, value);
        }
        return greatest;
    }
}
