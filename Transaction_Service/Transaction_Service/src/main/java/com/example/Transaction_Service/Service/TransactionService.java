package com.example.Transaction_Service.Service;


import com.example.Transaction_Service.Model.Transaction;
import com.example.Transaction_Service.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {


    @Autowired
    private TransactionRepo transactionRepo;


    // Effectuer une transaction
    public Transaction effectuerTransaction(Long clientId, Long titreId, int quantite, double prixUnitaire) {
        Transaction transaction = new Transaction();
        transaction.setClientId(clientId);
        transaction.setTitreId(titreId);
        transaction.setQuantite(quantite);
        transaction.setPrixUnitaire(prixUnitaire);

        return transactionRepo.save(transaction);
    }

    // Obtenir l'historique des transactions d'un client
    public List<Transaction> obtenirHistorique(Long clientId) {
        return transactionRepo.findByClientId(clientId);
    }


}
