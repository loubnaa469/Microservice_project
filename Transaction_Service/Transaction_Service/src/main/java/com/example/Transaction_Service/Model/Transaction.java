package com.example.Transaction_Service.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;
    private Long titreId;
    private int quantite;
    private double prixUnitaire;
    private String sens;
    private LocalDateTime dateTransaction;

    public Transaction() {
        this.dateTransaction = LocalDateTime.now();
    }




    public Transaction(Long id, Long clientId, Long titreId, int quantite, double prixUnitaire, LocalDateTime dateTransaction) {
        this.id = id;
        this.clientId = clientId;
        this.titreId = titreId;
        this.quantite = quantite;
        this.sens = sens;
        this.prixUnitaire = prixUnitaire;
        this.dateTransaction = dateTransaction;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


    public void setTitreId(Long titreId) {
        this.titreId = titreId;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getTitreId() {
        return titreId;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }
    public String getSens() {
        return sens;
    }

    public void setSens(String sens) {
        this.sens = sens;
    }
    @Transient
    private Client client;

    @Transient
    private Titre titre;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Titre getTitre() {
        return titre;
    }

    public void setTitre(Titre titre) {
        this.titre = titre;
    }
}
