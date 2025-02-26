package com.example.Client_Service.Service;

import com.example.Client_Service.Model.Client;
import com.example.Client_Service.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    ClientRepo repo;

    public List<Client> getClients() {
        return repo.findAll();
    }
}
