package com.example.Client_Service.Controller;
import com.example.Client_Service.Model.Client;
import com.example.Client_Service.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
@Autowired
    ClientService service;
    @FeignClient(name = "client-service")
    public interface ClientFeignClient {
        @GetMapping("/clients/{id}")
        ClientResponse getClientById(@PathVariable Long id);
    }

    class ClientResponse {
        private String email;
        public String getEmail() { return email; }
    }



@RequestMapping("/clients")
public List<Client> getClients(){
    return service.getClients();
}
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        Client client = service.getClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

}
