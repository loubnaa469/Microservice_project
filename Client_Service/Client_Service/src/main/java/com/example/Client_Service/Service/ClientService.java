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

    public void mettreAJourSolde(long clientId, double solde) {
        Optional<Client> clientOpt = repo.findById(clientId);
        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            client.setSolde(client.getSolde() + solde); // Mise à jour du solde
            repo.save(client);
        } else {
            throw new RuntimeException("Client non trouvé");
        }
    }

    // Récupérer tous les clients
    public List<Client> getClients() {
        return repo.findAll();
    }

    // Récupérer un client par son ID
    public Client getClientById(long id) {
        return repo.findById(id).orElse(null);
    }
}
