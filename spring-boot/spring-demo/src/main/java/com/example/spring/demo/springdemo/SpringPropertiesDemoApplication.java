package com.example.spring.demo.springdemo;

import com.example.spring.demo.springdemo.properties.SomeExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringPropertiesDemoApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(SpringPropertiesDemoApplication.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringPropertiesDemoApplication.class);

        SomeExternalService someExternalService = applicationContext.getBean(SomeExternalService.class);

        LOGGER.info("{}", someExternalService.returnServiceUrl());

    }

}
