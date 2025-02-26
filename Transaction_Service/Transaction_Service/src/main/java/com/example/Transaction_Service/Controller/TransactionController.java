package com.example.Transaction_Service.Controller;


import com.example.Transaction_Service.Model.Transaction;
import com.example.Transaction_Service.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Endpoint pour effectuer une transaction
    @PostMapping("/effectuer")
    public ResponseEntity<Transaction> effectuerTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.effectuerTransaction(
                transaction.getClientId(),
                transaction.getTitreId(),
                transaction.getQuantite(),
                transaction.getPrixUnitaire()
        );
        return ResponseEntity.ok(savedTransaction);
    }

    // Endpoint pour récupérer l'historique d'un client
    @GetMapping("/historique/{clientId}")
    public ResponseEntity<List<Transaction>> obtenirHistorique(@PathVariable Long clientId) {
        return ResponseEntity.ok(transactionService.obtenirHistorique(clientId));
    }

}
