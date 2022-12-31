package com.Fawry.payment_system.Exceptions;

public class InSuffecientBalance extends Exception{
    public InSuffecientBalance() {
        super();
    }

    public InSuffecientBalance(String message) {
        super(message);
    }
}
