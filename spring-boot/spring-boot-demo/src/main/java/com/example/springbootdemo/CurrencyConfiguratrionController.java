package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfiguratrionController {

    @Autowired
    private CurrencyConfiguration currencyConfiguration;
//    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @RequestMapping("/currency-configuration")
    public CurrencyConfiguration retrieveAllCourses() {
        return currencyConfiguration;
    }
}
