package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Records.MobileRechargeParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Fawry-System/Mobile-Recharge-Services")
public class MobileRechargeController {
    private PaymentController paymentController;

    @Autowired
    public MobileRechargeController(PaymentController paymentController){
        this.paymentController = paymentController;
    }
    @PostMapping("/Vodafone-Mobile/Recharge")
    public String vodafonePay(@RequestBody MobileRechargeParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/Etisalat-Mobile/Recharge")
    public String etisalatPay(@RequestBody MobileRechargeParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/Orange-Mobile/Recharge")
    public String orangePay(@RequestBody MobileRechargeParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/We-Mobile/Recharge")
    public String wePay(@RequestBody MobileRechargeParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }
}
