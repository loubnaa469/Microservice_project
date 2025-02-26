package com.example.Titre_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class TitreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TitreServiceApplication.class, args);
	}

}
