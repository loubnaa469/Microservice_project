package com.example.Titre_Service.repo;

import com.example.Titre_Service.Model.Titre;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitreRepo extends JpaRepository<Titre,Long> {
}
