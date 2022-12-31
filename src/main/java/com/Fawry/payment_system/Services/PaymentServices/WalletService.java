package com.Fawry.payment_system.Services.PaymentServices;

import com.Fawry.payment_system.Exceptions.InSuffecientBalance;
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
@Qualifier("Wallet")
public class WalletService implements PaymentMethod{
    private WalletRepository walletRepository;
    private TransactionService transactionService;

    @Autowired
    public WalletService(WalletRepository walletRepository, TransactionService transactionService){
        this.walletRepository = walletRepository;
        this.transactionService = transactionService;
    }

    @Override
    public TransactionStatus pay(PaymentParameters parameters){
        return payForService(
                parameters.userId(),
                parameters.userId(),
                TransactionType.PaymentTransaction,
                parameters.amount());
    }
    public TransactionStatus payForService(Integer walletId,
                                           Integer serviceId,
                                           TransactionType transactionType,
                                           int amount){
        TransactionStatus transactionStatus;
        try{
            transactionStatus = payProcess(walletId, serviceId, amount);
        } catch (InSuffecientBalance e){
            System.out.println(e.getMessage());
            transactionStatus = TransactionStatus.REJECTED;
        } catch (Exception e){
            System.out.println(e.getMessage());
            transactionStatus = TransactionStatus.FAILED;
        }

        Transaction transaction = new Transaction(
                walletId,
                serviceId,
                amount,
                transactionStatus,
                transactionType);

        transactionService.newPaymentTransaction(transaction);
        return transactionStatus;
    }

    public TransactionStatus payProcess(Integer walletId, Integer serviceId, int amount) throws Exception{
        Wallet userWallet = walletRepository.findById(walletId).get();
        Wallet serviceWallet = walletRepository.findById(serviceId).get();
        checkEnoughBalance(userWallet.getBalance(), amount);
        userWallet.subtractBalanceBy(amount);
        serviceWallet.addBalance(amount);
        walletRepository.save(userWallet);
        walletRepository.save(serviceWallet);
        return TransactionStatus.COMPLETED;
    }

    public void checkEnoughBalance(int balance, int amountToPay) throws Exception{
        if(balance < amountToPay){
            throw new InSuffecientBalance("Insufficient balance... :(");
        }
    }

    public Wallet getWallet(int walletId){
        return walletRepository.findById(walletId).get();
    }

    public void update(Wallet wallet) {
        walletRepository.save(wallet);
    }
}
