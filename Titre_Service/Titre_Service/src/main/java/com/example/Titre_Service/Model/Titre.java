package com.example.Titre_Service.Model;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "titres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Titre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String categorie;


}
