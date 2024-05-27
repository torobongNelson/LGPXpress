package org.smartapplication.exceptions;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
