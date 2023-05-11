package com.mockito.mockitodemo.business;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.crypto.Data;

@AllArgsConstructor
public class SomeBusinessImpl {
    private DataService dataService;

    public int findGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int value : data) {
            greatestValue = Math.max(value, greatestValue);
        }

        return greatestValue;
    }
}


interface DataService {
    int[] retrieveAllData();
}

