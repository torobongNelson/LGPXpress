package org.smartapplication.exceptions;

public class UnpaidOrderAlreadyExists extends RuntimeException {
    public UnpaidOrderAlreadyExists(String message) {
        super(message);
    }
}
