package com.rk.springaop.business;

import com.rk.springaop.aspect.annotations.TrackTime;
import com.rk.springaop.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    @Autowired
    private Dao1 dao1;

    @TrackTime
    public String calculateSomething() {
        //some business logic
        return dao1.retrieveSomething();
    }
}
