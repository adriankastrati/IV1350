package se.kth.processSale.controller;

public class OperationFailedException extends Exception {
    public OperationFailedException(String msg, Exception cause){
        super(msg, cause);
    }
}
