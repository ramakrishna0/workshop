package com.rk.springaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

    public String retrieveSomething() {
        return "some data from Dao2";
    }
}
