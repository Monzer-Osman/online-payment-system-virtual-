package com.Fawry.payment_system.Exceptions;

public class InvalidDiscountCode extends Exception{
    public InvalidDiscountCode() {
        super();
    }

    public InvalidDiscountCode(String message) {
        super(message);
    }
}
