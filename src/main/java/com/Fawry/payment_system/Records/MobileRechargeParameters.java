package com.Fawry.payment_system.Records;

public record MobileRechargeParameters(Integer userId,
                                       String phoneNumber,
                                       int amount,
                                       String paymentMethod) { }
