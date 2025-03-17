package com.example.Client_Service.AOP;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.example.Client_Service.Service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        LOGGER.info("Exécution de {} terminée en {} ms", joinPoint.getSignature().toShortString(), duration);
        return result;
    }
}

