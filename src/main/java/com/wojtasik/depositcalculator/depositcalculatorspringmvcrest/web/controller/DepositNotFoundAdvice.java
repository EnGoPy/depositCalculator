package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.controller;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.DepositNotFoundException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.FutureDateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DepositNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DepositNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String depositNotFoundHandler(DepositNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(FutureDateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String depositNotFoundHandler(FutureDateException ex){
        return ex.getMessage();
    }

}
