package com.Fawry.payment_system.Records;

public record PaymentParameters(Integer userId, Integer serviceId, int amount, String transactionType) {
}
