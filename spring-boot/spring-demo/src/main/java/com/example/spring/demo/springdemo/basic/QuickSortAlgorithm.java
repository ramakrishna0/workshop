package com.example.spring.demo.springdemo.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm {

    public void sort (int[] numbers) {
        System.out.println(this.getClass());
    }
}
