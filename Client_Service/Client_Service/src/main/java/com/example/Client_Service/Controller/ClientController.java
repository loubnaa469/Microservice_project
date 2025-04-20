package com.example.Client_Service.Controller;
import com.example.Client_Service.Model.Client;
import com.example.Client_Service.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    // Liste de tous les clients
    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        List<Client> clients = service.getClients();
        return ResponseEntity.ok(clients);
    }

    // Client par ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        Client client = service.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client updatedClient) {
        Client existingClient = service.getClientById(id);
        if (existingClient == null) {
            return ResponseEntity.notFound().build();
        }

        existingClient.setSolde(updatedClient.getSolde());
        // Tu peux aussi mettre à jour d'autres champs si nécessaire

        Client savedClient = service.saveClient(existingClient);
        return ResponseEntity.ok(savedClient);
    }

}

