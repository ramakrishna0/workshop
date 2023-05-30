package com.rk.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AfterAopAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(value = "com.rk.springaop.aspect.CommonJoinPointConfig.dataLayerPointCut()",
                    returning= "result")
    public void before(JoinPoint joinPoint, Object result) {
        LOGGER.info("{} returned with value - {}", joinPoint, result);
    }

    @AfterThrowing(value = "com.rk.springaop.aspect.CommonJoinPointConfig.dataLayerPointCut()",
                    throwing = "exception")
    public void afterThrowingException(JoinPoint joinPoint, Exception exception) {
            LOGGER.info("{} throw exception - {}", joinPoint, exception.toString());
    }

    @After("com.rk.springaop.aspect.CommonJoinPointConfig.dataLayerPointCut()")
    public void after(JoinPoint joinPoint) {
        LOGGER.info("after execution of - {}", joinPoint);
    }

}
