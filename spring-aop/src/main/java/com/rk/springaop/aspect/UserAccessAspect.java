package com.rk.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class UserAccessAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    //@Before("POINTCUT")  POINTCUT = "execution(returntype PACKAGE.className.methodNAme.parameters)"
    @Before("com.rk.springaop.aspect.CommonJoinPointConfig.dataLayerPointCut()")
    public void before(JoinPoint joinPoint) {
        LOGGER.info("checking access for method call - {}", joinPoint);
    }
}
