package com.Fawry.payment_system.Services;

import com.Fawry.payment_system.Models.Transaction;
import com.Fawry.payment_system.Repositories.TransactionRepository;
import com.Fawry.payment_system.enums.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService{
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public TransactionStatus newPaymentTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction.getTransactionStatus();
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
