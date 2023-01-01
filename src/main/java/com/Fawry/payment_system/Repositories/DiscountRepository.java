package com.Fawry.payment_system.Repositories;

import com.Fawry.payment_system.Models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
}
