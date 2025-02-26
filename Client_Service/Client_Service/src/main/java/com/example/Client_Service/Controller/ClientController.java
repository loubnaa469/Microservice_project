package com.example.Client_Service.Controller;


import com.example.Client_Service.Model.Client;
import com.example.Client_Service.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
@Autowired
    ClientService service;

@RequestMapping("/clients")
public List<Client> getClients(){
    return service.getClients();
}
}
