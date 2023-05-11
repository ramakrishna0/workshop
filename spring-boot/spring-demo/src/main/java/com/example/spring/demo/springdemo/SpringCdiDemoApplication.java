package com.example.spring.demo.springdemo;

import com.example.spring.demo.springdemo.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringCdiDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCdiDemoApplication.class);

    public static void main(String[] args) {
//		SpringApplication.run(SpringDemoApplication.class, args);   //Autogenerated by spring starter io
//        ApplicationContext applicationContext = SpringApplication.run(SpringCdiDemoApplication.class, args);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCdiDemoApplication.class);

        SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);

        LOGGER.info("{}, dao {}", someCdiBusiness, someCdiBusiness.getSomeCdiDAO());

    }

}
