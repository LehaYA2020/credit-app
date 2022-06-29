package ru.logstream.creditapp.exceptions;

public class CreditNotApprovedException extends RuntimeException{
    public CreditNotApprovedException(String message) {
        super(message);
    }
}
