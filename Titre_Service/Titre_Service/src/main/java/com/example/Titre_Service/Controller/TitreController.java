package com.example.Titre_Service.Controller;


import com.example.Titre_Service.Model.Titre;
import com.example.Titre_Service.Service.TitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/titres")
public class TitreController {
    private final TitreService titreService;

    @Autowired
    public TitreController(TitreService titreService) {
        this.titreService = titreService;
    }

    // Endpoint pour obtenir les détails d'un titre
    @GetMapping("/{id}")
    public Titre obtenirDetails(@PathVariable Long id) {
        return titreService.obtenirDetails(id);
    }


}
