package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class DepositModel {

    private Long id;
    @NotEmpty private String name;
    @NotEmpty private double debitRate;
    @NotEmpty private int capitalization;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public DepositModel() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDebitRate() {
        return debitRate;
    }

    public void setDebitRate(double debitRate) {
        this.debitRate = debitRate;
    }

    public int getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(int capitalization) {
        this.capitalization = capitalization;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "DepositModel{" +
                ", name='" + name + '\'' +
                ", debitRate=" + debitRate +
                ", capitalization=" + capitalization +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
