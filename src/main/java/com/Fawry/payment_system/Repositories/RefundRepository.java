package com.Fawry.payment_system.Repositories;

import com.Fawry.payment_system.Models.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund, Integer> {
}
