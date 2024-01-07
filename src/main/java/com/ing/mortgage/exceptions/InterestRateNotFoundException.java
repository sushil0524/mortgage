package com.ing.mortgage.exceptions;

public class InterestRateNotFoundException extends RuntimeException{
    public InterestRateNotFoundException(String message) {
        super(message);
    }

    public InterestRateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
