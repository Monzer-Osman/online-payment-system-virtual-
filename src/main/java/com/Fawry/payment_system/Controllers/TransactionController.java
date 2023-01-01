package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Models.Transaction;
import com.Fawry.payment_system.Services.TransactionService;
import com.Fawry.payment_system.enums.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fawry-System/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/get-all-transactions/{transactionType}")
    public List<Transaction> getUsersTransactions(TransactionStatus transactionType){
        return transactionService.getTransactionsOfType(transactionType.toString());
    }

}
