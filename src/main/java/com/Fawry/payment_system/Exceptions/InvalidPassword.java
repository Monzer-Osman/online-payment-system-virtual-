package com.Fawry.payment_system.Exceptions;

public class InvalidPassword extends Exception{
    public InvalidPassword() {
        super();
    }

    public InvalidPassword(String message) {
        super(message);
    }
}
