package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception;

public class FutureDateException extends RuntimeException {
    public FutureDateException() {
        super("Given date is out of chosen deposit time range.");
    }
}
