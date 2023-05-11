package com.example.spring.demo.springdemo.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
//@Primary
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm{

    public void sort (int[] numbers) {
        System.out.println(this.getClass());
    }
}
