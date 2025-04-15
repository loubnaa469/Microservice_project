package com.example.Transaction_Service.Model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long titreId;
    private int quantite;
    private double prixUnitaire;
    private String sens;
    private LocalDateTime dateTransaction = LocalDateTime.now();

    @Transient
    private Client client;

    @Transient
    private Titre titre;
}
