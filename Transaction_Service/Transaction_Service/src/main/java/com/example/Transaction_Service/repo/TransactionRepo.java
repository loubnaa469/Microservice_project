package com.example.Transaction_Service.repo;

import com.example.Transaction_Service.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {
    List<Transaction> findByClientId(Long clientId);
}
