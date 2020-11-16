package com.ivan;

public class WrongIndexesException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong input indexes!";
    }

}
