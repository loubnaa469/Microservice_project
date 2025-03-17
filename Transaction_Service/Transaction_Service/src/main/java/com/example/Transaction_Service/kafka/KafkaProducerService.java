package com.example.Transaction_Service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class.getName());
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransactionEvent(String message) {
        try {
            kafkaTemplate.send("transaction_topic", message);
            LOGGER.info("Message envoyé à Kafka : " + message);
        } catch (Exception e) {
            LOGGER.error("Erreur Kafka : " + e.getMessage());
        }
    }
}
