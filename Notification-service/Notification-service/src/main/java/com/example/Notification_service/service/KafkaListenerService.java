package com.example.Notification_service.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerService {

    @KafkaListener(topics = "transaction_topic", groupId = "client-service-group")
    public void consumeTransactionEvent(String message) {
        System.out.println("📩 Nouvelle notification reçue : " + message);
    }
}
