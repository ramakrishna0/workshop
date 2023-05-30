package com.example.spring.demo.springdemo.xml;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

public class XMLJDBCConnection {
    public XMLJDBCConnection() {
        System.out.println("JBDCConnection Created");
    }
}
