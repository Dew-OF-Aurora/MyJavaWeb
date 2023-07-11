package com.aurora.bank.exception;

public class NoMoneyException extends Exception{
    public NoMoneyException(String msg){
        super(msg);
    }

    public NoMoneyException() {
    }
}
