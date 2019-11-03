package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
        super("Invalid input.");
    }
}
