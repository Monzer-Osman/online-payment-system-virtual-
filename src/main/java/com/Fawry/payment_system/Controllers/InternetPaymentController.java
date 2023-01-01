package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Records.InternetPaymentParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/Fawry-System/Internet-Payment-Services/")
public class InternetPaymentController {
    private PaymentController paymentController;

    @Autowired
    public InternetPaymentController(PaymentController paymentController) {
        this.paymentController = paymentController;
    }

    @PostMapping("/Vodafone-Internet/pay")
    public String vodafonePay(InternetPaymentParameters parameters) {
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/Etisalat-Internet/pay")
    public String etisalatPay(InternetPaymentParameters parameters) {
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/Orange-Internet/pay")
    public String orangePay(InternetPaymentParameters parameters) {
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/We-Internet/pay")
    public String wePay(InternetPaymentParameters parameters) {
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }
}
