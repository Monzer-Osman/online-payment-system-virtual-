package com.Fawry.payment_system.Records;

public record InternetPaymentParameters (String landlineNumber,
                                         int amount,
                                         String paymentMethod){}
