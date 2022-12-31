package com.Fawry.payment_system.Services.PaymentServices;

import com.Fawry.payment_system.Models.Transaction;
import com.Fawry.payment_system.Models.Wallet;
import com.Fawry.payment_system.Records.PaymentParameters;
import com.Fawry.payment_system.Repositories.WalletRepository;
import com.Fawry.payment_system.Services.TransactionService;
import com.Fawry.payment_system.enums.TransactionStatus;
import com.Fawry.payment_system.enums.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("CreditCard")
public class CreditCardService implements PaymentMethod {
    private WalletService walletService;
    private TransactionService transactionService;

    @Autowired
    public CreditCardService(WalletService walletService, TransactionService transactionService){
        this.walletService = walletService;
        this.transactionService = transactionService;
    }

    @Override
    public TransactionStatus pay(PaymentParameters parameters){
        Transaction transaction = new Transaction(
                parameters.userId(),
                parameters.serviceId(),
                parameters.amount(),
                TransactionStatus.COMPLETED,
                TransactionType.PaymentTransaction
        );
        return transactionService.newPaymentTransaction(transaction);
    }

    public TransactionStatus walletRecharge(PaymentParameters parameters){
        Wallet wallet = walletService.getWallet(parameters.serviceId());
        wallet.addBalance((parameters.amount()));
        walletService.update(wallet);
        Transaction transaction  = new Transaction(
                parameters.userId(),
                parameters.serviceId(),
                parameters.amount(),
                TransactionStatus.COMPLETED,
                TransactionType.WalletRechargeTransaction);
       return  transactionService.newPaymentTransaction(transaction);
    }
}
