package com.Fawry.payment_system.Exceptions;

public class EmailRegisteredBeforeException extends Exception{

    public EmailRegisteredBeforeException() {
        super();
    }

    public EmailRegisteredBeforeException(String message) {
        super(message);
    }
}
