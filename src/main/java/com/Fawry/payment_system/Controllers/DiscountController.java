package com.Fawry.payment_system.Controllers;

import com.Fawry.payment_system.Models.Discount;
import com.Fawry.payment_system.Services.DiscountService;
import com.Fawry.payment_system.Services.RefundService;
import com.Fawry.payment_system.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fawry-System/discounts")
public class DiscountController {

    private DiscountService discountService;

    @Autowired
    public DiscountController(TransactionService transactionService,
                               DiscountService discountService,
                               RefundService refundService){
        this.discountService = discountService;
    }

    @PostMapping("/add-discount")
    public void addDiscount(@RequestBody Discount discount){
        discountService.addNewDiscount(discount);
    }

    @GetMapping("/available-discounts")
    public List<Discount> getDiscounts(){
        return discountService.getAllDiscounts();
    }

}
