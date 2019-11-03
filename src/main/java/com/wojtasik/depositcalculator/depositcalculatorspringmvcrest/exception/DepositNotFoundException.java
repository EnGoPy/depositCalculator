package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception;

public class DepositNotFoundException extends RuntimeException {

    public DepositNotFoundException(Long id) {
        super("Could not find deposit with id = " + id);
    }
}
