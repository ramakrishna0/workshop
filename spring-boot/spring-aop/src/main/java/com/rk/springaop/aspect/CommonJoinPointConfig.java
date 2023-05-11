package com.rk.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.rk.springaop.data.*.*(..))")
    public void dataLayerPointCut() {}

    @Pointcut("execution(* com.rk.springaop.business.*.*(..))")
    public void businessLayerPointCut() {}

    @Pointcut("dataLayerPointCut() && businessLayerPointCut()")
    public void allLayerPointCut() {}

    @Pointcut("@annotation(com.rk.springaop.aspect.annotations.TrackTime)")
    public void trackTime() {}
}
