package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Records.LandlineParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Fawry-System/landline-services")
public class LandlineController {
    PaymentController paymentController;

    @Autowired
    public LandlineController(PaymentController paymentController){
        this.paymentController = paymentController;
    }

    @GetMapping("/monthly-receipt/pay")
    public String monthlyLandline(@RequestBody LandlineParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

    @GetMapping("/quarter-receipt/pay")
    public String quarterLandline(@RequestBody LandlineParameters parameters){
        return "redirect::Fawry-System/payment-services/choose-payment-method/" + parameters.paymentMethod();
    }

}
