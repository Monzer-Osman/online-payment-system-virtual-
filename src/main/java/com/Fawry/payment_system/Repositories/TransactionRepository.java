package com.Fawry.payment_system.Repositories;

import com.Fawry.payment_system.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "SELECT * FROM transactions WHERE transactionType = ?1", nativeQuery = true)
    public List<Transaction> getAllTransactionOfType(String type);
}
