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
    // Effectuer une transaction
    @PostMapping("/effectuer")
    public ResponseEntity<Transaction> effectuerTransaction(@RequestBody Transaction transaction) {
        if (transaction.getSens() == null ||
                (!transaction.getSens().equalsIgnoreCase("ACHAT") && !transaction.getSens().equalsIgnoreCase("VENTE"))) {
            return ResponseEntity.badRequest().body(null);
        }
        Transaction savedTransaction = transactionService.effectuerTransaction(
                transaction.getClientId(),
                transaction.getTitreId(),
                transaction.getQuantite(),
                transaction.getPrixUnitaire(),
                transaction.getSens()
        );
        return ResponseEntity.ok(savedTransaction);
    }

    // Récupérer l'historique d'un client
    @GetMapping("/historique/{clientId}")
    public ResponseEntity<List<Transaction>> obtenirHistorique(@PathVariable Long clientId) {
        List<Transaction> transactions = transactionService.obtenirHistorique(clientId);
        return transactions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(transactions);
    }
}
