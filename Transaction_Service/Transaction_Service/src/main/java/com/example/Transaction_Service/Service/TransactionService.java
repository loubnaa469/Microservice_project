package com.example.Transaction_Service.Service;
import com.example.Transaction_Service.Model.Client;
import com.example.Transaction_Service.Model.Titre;
import com.example.Transaction_Service.Model.Transaction;
import com.example.Transaction_Service.feignclients.ClientFeignClient;
import com.example.Transaction_Service.feignclients.TitreFeignClient;
import com.example.Transaction_Service.kafka.KafkaProducerService;
import com.example.Transaction_Service.repo.TransactionRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TransactionService {

    private static final Logger LOGGER = Logger.getLogger(TransactionService.class.getName());

    private final ClientFeignClient clientFeignClient;
    private final TitreFeignClient titreFeignClient;
    private final TransactionRepo transactionRepo;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public TransactionService(ClientFeignClient clientFeignClient, TitreFeignClient titreFeignClient,
                              TransactionRepo transactionRepo, KafkaProducerService kafkaProducerService) {
        this.clientFeignClient = clientFeignClient;
        this.titreFeignClient = titreFeignClient;
        this.transactionRepo = transactionRepo;
        this.kafkaProducerService = kafkaProducerService;
    }

    public Client getClientById(Long clientId) {
        return clientFeignClient.getClientById(clientId);
    }
    public Titre getTitreById(Long titreId) {
        return titreFeignClient.getTitreById(titreId);
    }

    @Transactional
    public Transaction effectuerTransaction(Long clientId, Long titreId, int quantite, double prixUnitaire, String sens) {
        if (sens == null || (!sens.equalsIgnoreCase("ACHAT") && !sens.equalsIgnoreCase("VENTE"))) {
            throw new IllegalArgumentException("Le sens doit être 'ACHAT' ou 'VENTE'.");
        }

        LOGGER.info("Début de la transaction pour le client " + clientId + " avec le titre " + titreId);

        Client client = getClientById(clientId);
        if (client == null) {
            throw new RuntimeException("Client non trouvé !");
        }

        Titre titre = getTitreById(titreId);
        if (titre == null) {
            throw new RuntimeException("Titre non trouvé !");
        }

        double montant = quantite * prixUnitaire;
        if (sens.equalsIgnoreCase("ACHAT")) {
            montant = -montant;
        }

        Transaction transaction = new Transaction();
        transaction.setClientId(clientId);
        transaction.setTitreId(titreId);
        transaction.setQuantite(quantite);
        transaction.setPrixUnitaire(prixUnitaire);
        transaction.setSens(sens);

        transactionRepo.save(transaction);
        LOGGER.info("Transaction sauvegardée avec succès : " + transaction);

        String message = clientId + "," + montant;
        try {
            kafkaProducerService.sendTransactionEvent(message);
            LOGGER.info("Message Kafka envoyé : " + message);
        } catch (Exception e) {
            LOGGER.severe("Erreur lors de l'envoi du message Kafka : " + e.getMessage());
        }

        return transaction;
    }

    public List<Transaction> obtenirHistorique(Long clientId) {
        List<Transaction> transactions = transactionRepo.findByClientId(clientId);

        for (Transaction transaction : transactions) {
            transaction.setClient(getClientById(transaction.getClientId()));
            transaction.setTitre(getTitreById(transaction.getTitreId()));
        }

        return transactions;
    }
}
