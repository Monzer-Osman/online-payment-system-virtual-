package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Records.PaymentParameters;
import com.Fawry.payment_system.Services.PaymentServices.CreditCardService;
import com.Fawry.payment_system.Services.PaymentServices.PaymentMethod;
import com.Fawry.payment_system.enums.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/choose-payment-method/{paymentMethod}")
    public java.lang.String paymentMethod(@PathVariable java.lang.String paymentMethod){
        if(paymentMethod.equals("credit-card")){
            return "redirect::/Fawry-System/payment-services/credit-card/pay";
        }
        else if(paymentMethod.equals("wallet")){
            return "redirect::/Fawry-System/payment-services/wallet/pay";
        }
        else {
            return "we're sorry this payment method is not supported yet .. :(";
        }
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
