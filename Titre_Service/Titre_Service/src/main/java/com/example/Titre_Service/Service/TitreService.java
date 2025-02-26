package com.example.Titre_Service.Service;

import com.example.Titre_Service.Model.Titre;
import com.example.Titre_Service.repo.TitreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitreService {

    private final TitreRepo titreRepo;

    @Autowired
    public TitreService(TitreRepo titreRepo) {
        this.titreRepo = titreRepo;
    }

    // Méthode pour obtenir les détails d'un titre
    public Titre obtenirDetails(Long titreId) {
        return titreRepo.findById(titreId)
                .orElseThrow(() -> new RuntimeException("Titre non trouvé avec ID : " + titreId));
}}
