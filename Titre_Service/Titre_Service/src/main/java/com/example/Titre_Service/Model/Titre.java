package com.example.Titre_Service.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Titres")
@Getter
@Setter
@ToString
public class Titre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String categorie;

    // Constructeur personnalisé
    public Titre(String libelle, String categorie) {
        this.libelle = libelle;
        this.categorie = categorie;
    }

    public Titre() {
    }

    public Titre(Long id, String libelle, String categorie) {
        this.id = id;
        this.libelle = libelle;
        this.categorie = categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCategorie() {
        return categorie;
    }
}
