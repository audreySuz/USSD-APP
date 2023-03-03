package com.drey.ussdapp.exceptions;

public class InsufficientBalanceException extends RuntimeException{


    public InsufficientBalanceException(String message, Exception cause) {
        super(message, cause);
    }

    public InsufficientBalanceException(String message){
        super(message);
    }
}
