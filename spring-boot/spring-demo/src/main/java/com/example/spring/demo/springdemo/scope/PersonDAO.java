package com.example.spring.demo.springdemo.scope;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Getter @Setter
public class PersonDAO {
    @Autowired
    private JDBCConnection jdbcConnection;
}
