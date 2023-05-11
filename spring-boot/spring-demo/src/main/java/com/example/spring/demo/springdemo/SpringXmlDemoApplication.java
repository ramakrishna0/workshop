package com.example.spring.demo.springdemo;

import com.example.spring.demo.springdemo.scope.PersonDAO;
import com.example.spring.demo.springdemo.xml.XMLPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringXmlDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringXmlDemoApplication.class);

    public static void main(String[] args) {
        /*ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        XMLPersonDAO xmlPersonDAO = (XMLPersonDAO) applicationContext.getBean("xmlPersonDAO");

        PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);

        LOGGER.info("{}", xmlPersonDAO);
        LOGGER.info("{}", xmlPersonDAO.getXmljdbcConnection());

        LOGGER.info("{}", personDAO);

        LOGGER.info("{}", (Object) applicationContext.getBeanDefinitionNames());

    }

}
