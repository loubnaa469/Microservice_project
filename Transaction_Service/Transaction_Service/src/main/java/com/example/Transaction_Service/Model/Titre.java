package com.example.Transaction_Service.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Titres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Titre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String categorie;
}
