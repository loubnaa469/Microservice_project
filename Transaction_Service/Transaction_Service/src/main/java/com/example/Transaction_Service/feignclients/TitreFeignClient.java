package com.example.Transaction_Service.feignclients;

import com.example.Transaction_Service.Model.Titre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Titre-Service")
public interface TitreFeignClient {
    @GetMapping("/Titres/{id}")
    Titre getTitreById(@PathVariable("id") Long id);
}
