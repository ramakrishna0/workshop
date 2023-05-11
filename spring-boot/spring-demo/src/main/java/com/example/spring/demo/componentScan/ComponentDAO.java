package com.example.spring.demo.componentScan;

import com.example.spring.demo.springdemo.scope.JDBCConnection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Getter @Setter
public class ComponentDAO {
    @Autowired
    private ComponentJDBCConnection jdbcConnection;
}
