package com.Fawry.payment_system.Exceptions;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String message){
        super(message);
    }

    public void printErrorMessage(){
        System.out.println("Wrong Password");
    }
}
