package com.example.Client_Service.kafka;

import com.example.Client_Service.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumerService {

    @Autowired
    private ClientService clientService;

    @KafkaListener(topics = "transaction_topic", groupId = "client-service-group")
    public void consumeTransactionEvent(String message) {
        System.out.println("Message reçu de Kafka: " + message);

        try {
            String[] parts = message.split(",");
            Long clientId = Long.parseLong(parts[0]);
            double solde = Double.parseDouble(parts[1]);

            // Mettre à jour le solde du client
            clientService.mettreAJourSolde(clientId,solde );
            System.out.println("Solde mis à jour pour le client " + clientId);
        } catch (Exception e) {
            System.err.println("Erreur lors du traitement du message Kafka: " + e.getMessage());
        }
    }
}
