package com.example.Client_Service.Service;
import com.example.Client_Service.Model.Client;
import com.example.Client_Service.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepo repo;


    // Récupérer tous les clients
    public List<Client> getClients() {
        return repo.findAll();
    }

    // Récupérer un client par son ID
    public Client getClientById(long id) {
        return repo.findById(id).orElse(null);
    }


    public Client saveClient(Client client) {
        return repo.save(client);
    }
}
