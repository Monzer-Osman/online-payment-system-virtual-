package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Records.PaymentParameters;
import com.Fawry.payment_system.Services.PaymentServices.CreditCardService;
import com.Fawry.payment_system.Services.PaymentServices.PaymentMethod;
import com.Fawry.payment_system.enums.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Fawry-System/payment-services")
public class PaymentController {
    private CreditCardService creditCard;
    private PaymentMethod wallet;

    @Autowired
    public PaymentController(
            CreditCardService creditCard,
            @Qualifier("Wallet") PaymentMethod wallet){
        this.creditCard = creditCard;
        this.wallet = wallet;
    }

    @PostMapping("wallet/pay")
    public TransactionStatus walletPayment(@RequestBody PaymentParameters parameters){
        return wallet.pay(parameters);
    }

    @PostMapping("credit-card/pay")
    public TransactionStatus creditcardPayment(@RequestBody PaymentParameters parameters){
        return creditCard.pay(parameters);
    }

    @PostMapping("credit-card/recharge-wallet")
    public TransactionStatus rechargeWallet(@RequestBody PaymentParameters parameters){
        return creditCard.walletRecharge(parameters);
    }
}
