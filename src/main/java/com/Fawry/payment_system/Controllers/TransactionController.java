package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Models.Transaction;
import com.Fawry.payment_system.Services.TransactionService;
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

    @GetMapping("/get-all-transactions")
    public List<Transaction> getUsersTransactions(){
        return transactionService.getAllTransactions();
    }

}
