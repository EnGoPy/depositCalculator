package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DepositWithCalculationModel {

    private Long id;
    private String name;
    private double debitRate;
    private int capitalization;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<CalculationForListModel> calculations = new ArrayList<>();

    public DepositWithCalculationModel() {
    }

    public DepositWithCalculationModel(Long id, String name, double debitRate, int capitalization, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.debitRate = debitRate;
        this.capitalization = capitalization;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CalculationForListModel> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<CalculationForListModel> calculations) {
        this.calculations = calculations;
    }

    @Override
    public String toString() {
        return "DepositWithCalculationModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", debitRate=" + debitRate +
                ", capitalization=" + capitalization +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", calculations=" + calculations +
                '}';
    }
}
