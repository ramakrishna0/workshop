package com.rk.springaop.data;

import com.rk.springaop.aspect.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public String retrieveSomething() {
        return "some data from Dao1";
    }
}
