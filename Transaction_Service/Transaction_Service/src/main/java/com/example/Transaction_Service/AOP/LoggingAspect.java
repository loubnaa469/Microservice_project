package com.example.Transaction_Service.AOP;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut pour toutes les méthodes dans TransactionService
    @Pointcut("execution(* com.example.Transaction_Service.Service.TransactionService.*(..))")
    public void serviceMethods() {}

    // Avant l'exécution de la méthode
    @Before("serviceMethods()")
    public void logBeforeMethodExecution() {
        LOGGER.info("Début de l'exécution de la méthode...");
    }

    // Après le succès de l'exécution de la méthode
    @AfterReturning(value = "serviceMethods()", returning = "result")
    public void logAfterMethodExecution(Object result) {
        Signature signature = ((org.aspectj.lang.JoinPoint) result).getSignature();
        LOGGER.info("Méthode " + signature.getName() + " exécutée avec succès. Résultat : " + result);
    }

    // Si une exception est lancée pendant l'exécution
    @AfterThrowing(value = "serviceMethods()", throwing = "exception")
    public void logMethodException(Exception exception) {
        LOGGER.error("Erreur dans l'exécution de la méthode : " + exception.getMessage(), exception);
    }
}
