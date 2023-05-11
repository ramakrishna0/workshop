package com.rk.springaop.business;

import com.rk.springaop.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    @Autowired
    private Dao2 dao2;

    public String calculateSomething() {
        //some business logic
        return dao2.retrieveSomething();
    }

}
