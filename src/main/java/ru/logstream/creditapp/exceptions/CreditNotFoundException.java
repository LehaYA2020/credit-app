package ru.logstream.creditapp.exceptions;

public class CreditNotFoundException extends RuntimeException {
    public CreditNotFoundException(String message) {
        super(message);
    }
}
