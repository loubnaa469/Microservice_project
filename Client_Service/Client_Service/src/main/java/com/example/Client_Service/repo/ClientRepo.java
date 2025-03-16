package com.example.Client_Service.repo;

import com.example.Client_Service.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
