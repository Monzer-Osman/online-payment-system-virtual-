package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Records.DonationParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Fawry-System/Donation-Services")
public class DonationController {
    private PaymentController paymentController;

    @Autowired
    public DonationController(PaymentController paymentController){
        this.paymentController = paymentController;
    }

    @PostMapping("/school/donate")
    public String schoolDonate(@RequestBody DonationParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/NGO/donate")
    public String organizationDonate(@RequestBody DonationParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @PostMapping("/hospital/donate")
    public String hospitalDonate(@RequestBody DonationParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }
}
