package com.Fawry.payment_system.Services.PaymentServices;
import com.Fawry.payment_system.Records.PaymentParameters;
import com.Fawry.payment_system.enums.TransactionStatus;

public interface PaymentMethod {
    TransactionStatus pay(PaymentParameters parameters);
}
