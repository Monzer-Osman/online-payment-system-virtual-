package com.Fawry.payment_system.Controllers;

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

    @GetMapping("/monthly-receipt/{receiptNumber}")
    public String monthlyLandline(@PathVariable String receiptNumber){
        return "redirect::/Fawry-System/payment-services/credit-card/pay";
    }

    @GetMapping("/quarter-receipt/{receiptNumber}")
    public String quarterLandline(@PathVariable String receiptNumber){
        return "redirect::/Fawry-System/payment-services/credit-card/pay";
    }

}
