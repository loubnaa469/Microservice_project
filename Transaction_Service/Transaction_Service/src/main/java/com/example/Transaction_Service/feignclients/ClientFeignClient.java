package com.example.Transaction_Service.feignclients;


import com.example.Transaction_Service.Model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Client-Service")
public interface ClientFeignClient {
    @GetMapping("/clients/{id}")
    Client getClientById(@PathVariable("id") Long id);
}
