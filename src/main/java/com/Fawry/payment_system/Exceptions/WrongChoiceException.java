package com.Fawry.payment_system.Exceptions;

public class WrongChoiceException extends Exception{
    public WrongChoiceException() {
        super();
    }

    public WrongChoiceException(String message) {
        super(message);
    }
}
