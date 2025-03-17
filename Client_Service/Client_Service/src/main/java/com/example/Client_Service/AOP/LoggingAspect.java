package com.example.Client_Service.AOP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.Client_Service.Service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        LOGGER.info("Début de l'exécution de : {} avec arguments : {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* com.example.Client_Service.Service.*.*(..))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        LOGGER.info("Fin de l'exécution de : {} - Résultat : {}",
                joinPoint.getSignature().toShortString(),
                result);
    }
}
