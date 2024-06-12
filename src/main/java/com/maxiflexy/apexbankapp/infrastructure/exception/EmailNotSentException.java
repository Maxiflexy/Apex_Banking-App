package com.maxiflexy.apexbankapp.infrastructure.exception;

public class EmailNotSentException extends RuntimeException{
    public EmailNotSentException(String message) {
        super(message);
    }
}
