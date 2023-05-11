package com.rk.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class MethodExecutionTimeCalculationAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

//    @Around(value = "execution(* com.rk.springaop.business..*(..))" )
//    @Around(value = "com.rk.springaop.aspect.CommonJoinPointConfig.businessLayerPointCut()")
//    @Around(value = "CommonJoinPointConfig.businessLayerPointCut()")
    @Around("com.rk.springaop.aspect.CommonJoinPointConfig.trackTime()")
    public Object before(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object returnValue = pjp.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        LOGGER.info("Time taken by {}  to execute is {}ms", pjp, timeTaken);
        return returnValue;
    }

}
