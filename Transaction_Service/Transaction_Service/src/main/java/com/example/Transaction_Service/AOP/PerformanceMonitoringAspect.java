package com.example.Transaction_Service.AOP;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitoringAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.example.Transaction_Service.Service.TransactionService.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // Log avant l'exécution de la méthode
        LOGGER.info("Exécution de la méthode : " + joinPoint.getSignature().getName() + " avec les arguments : " + java.util.Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed(); // Exécution de la méthode

        long endTime = System.currentTimeMillis();
        LOGGER.info("Méthode exécutée : " + joinPoint.getSignature().getName());
        LOGGER.info("Temps d'exécution de la méthode : " + (endTime - startTime) + " ms");

        return result;
    }
}
