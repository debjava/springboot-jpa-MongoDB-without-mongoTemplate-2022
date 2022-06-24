package com.ddlab.rnd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class TimeTracker {

    @Around("@annotation(LogTime)")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final Object proceed = joinPoint.proceed();
        stopWatch.stop();
        log.debug("{} executed in {} seconds", joinPoint.getSignature(), stopWatch.getTotalTimeSeconds());

        return proceed;
    }
}
