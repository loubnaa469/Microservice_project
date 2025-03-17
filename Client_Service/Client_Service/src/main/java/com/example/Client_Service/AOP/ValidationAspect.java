package com.example.Client_Service.AOP;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Before("execution(* com.example.Client_Service.Service.ClientService.mettreAJourSolde(..)) && args(clientId, solde)")
    public void validateSolde(JoinPoint joinPoint, long clientId, double solde) {
        if (clientId <= 0) {
            throw new IllegalArgumentException("L'ID du client doit être positif");
        }
        if (solde == 0) {
            throw new IllegalArgumentException("Le solde ne peut pas être zéro");
        }
        LOGGER.info("Validation réussie pour mettreAJourSolde avec clientId={} et solde={}", clientId, solde);
    }
}
