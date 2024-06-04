package org.smartapplication.exceptions;

public class UnpaidOrderAlreadyExists extends Exception{
    public UnpaidOrderAlreadyExists(String message){
        super(message);
    }
}
