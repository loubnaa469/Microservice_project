package com.example.Transaction_Service.AOP;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class
InputValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(InputValidationAspect.class);

    @Pointcut("execution(* com.example.Transaction_Service.Service.TransactionService.effectuerTransaction(..))")
    public void transactionMethod() {}

    @Before("transactionMethod() && args(clientId, titreId, quantite, prixUnitaire, sens)")
    public void validateInput(Long clientId, Long titreId, int quantite, double prixUnitaire, String sens) {
        LOGGER.info("Vérification des entrées pour la méthode effectuerTransaction...");
        LOGGER.info("Entrées : clientId = " + clientId + ", titreId = " + titreId + ", quantite = " + quantite + ", prixUnitaire = " + prixUnitaire + ", sens = " + sens);

        // Exemple de validation des entrées
        if (clientId == null || titreId == null) {
            LOGGER.error("Validation échouée : Client ID et Titre ID doivent être fournis.");
            throw new IllegalArgumentException("Client ID et Titre ID doivent être fournis.");
        }
        if (quantite <= 0 || prixUnitaire <= 0) {
            LOGGER.error("Validation échouée : Quantité et prix unitaire doivent être supérieurs à zéro.");
            throw new IllegalArgumentException("Quantité et prix unitaire doivent être supérieurs à zéro.");
        }
        LOGGER.info("Validation des entrées réussie.");
    }
}
