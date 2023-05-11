package com.example.spring.demo.springdemo.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {SpringBasicDemoApplication.class})
@ContextConfiguration(locations = {"/testConfig.xml"})
public class BinarySearchTest {

    @Autowired
    private BinarySearchImpl binarySearch;

    @Test
    public void testBasicScenario() {
        assertEquals(5,binarySearch.binarySearch(new int[]{}, 5));
    }

}
