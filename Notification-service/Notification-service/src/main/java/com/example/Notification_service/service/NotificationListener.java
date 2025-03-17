package com.example.Notification_service.service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    private final EmailService emailService;

    public NotificationListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "transaction_topic", groupId = "client-service-group")
    public void consumeTransactionEvent(String message) {
        System.out.println(" Message reçu de Kafka : " + message);

        // 🔹 Parser le message reçu (ex: "clientId,montant")
        String[] parts = message.split(",");
        if (parts.length != 2) {
            System.err.println("Format du message incorrect : " + message);
            return;
        }

        Long clientId = Long.parseLong(parts[0]);
        double montant = Double.parseDouble(parts[1]);

        // 🔹 Récupérer l'email du client via un appel Feign (si disponible)
        String email = getClientEmail(clientId);
        if (email == null) {
            System.err.println("⚠️ Impossible de récupérer l'email du client ID: " + clientId);
            return;
        }

        // 🔹 Construire le message d'email
        String subject = "Mise à jour de votre solde";
        String body = "Bonjour,\n\nVotre solde a été mis à jour suite à une transaction.\n" +
                "- Montant de la transaction : " + montant + "€\n\n" +
                "Merci pour votre confiance.";

        // 🔹 Envoyer l'email
        emailService.sendTransactionEmail(email, subject, body);
        System.out.println("✅ Email envoyé à : " + email);
    }

    // 🔹 Méthode pour récupérer l'email du client via Feign Client (si disponible)
    private String getClientEmail(Long clientId) {
        return "exemple@email.com"; // Remplace par un vrai appel
    }
}

