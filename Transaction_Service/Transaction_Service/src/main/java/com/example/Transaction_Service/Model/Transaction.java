package com.example.Transaction_Service.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data // génère getters, setters, toString, equals, hashCode
@NoArgsConstructor // constructeur sans arguments
@AllArgsConstructor // constructeur avec tous les champs
@Builder // pour créer des objets facilement via builder pattern
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long titreId;
    private int quantite;
    private double prixUnitaire;
    private String sens;
    private LocalDateTime dateTransaction = LocalDateTime.now(); // valeur par défaut

    @Transient
    private Client client;

    @Transient
    private Titre titre;
}
