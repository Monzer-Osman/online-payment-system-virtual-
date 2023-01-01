package com.Fawry.payment_system.Services;

import com.Fawry.payment_system.Models.Discount;
import com.Fawry.payment_system.Repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    private DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository){
        this.discountRepository = discountRepository;
    }

    public void addNewDiscount(Discount discount){
        discountRepository.save(discount);
    }

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }
}
