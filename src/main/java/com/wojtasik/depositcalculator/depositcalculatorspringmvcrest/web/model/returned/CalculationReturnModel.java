package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculationReturnModel {

    private BigDecimal amount;
    private LocalDate calculationDate;
    private String depositName;
    private String algorithmType;
    private BigDecimal profit;

    public CalculationReturnModel() {
    }

    public CalculationReturnModel(BigDecimal amount, LocalDate calculationDate, String depositName, String algorithmType, BigDecimal profit) {
        this.amount = amount;
        this.calculationDate = calculationDate;
        this.depositName = depositName;
        this.algorithmType = algorithmType;
        this.profit = profit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(LocalDate calculationDate) {
        this.calculationDate = calculationDate;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "CalculationReturnModel{" +
                "amount=" + amount +
                ", calculationDate=" + calculationDate +
                ", depositName='" + depositName + '\'' +
                ", algorithmType='" + algorithmType + '\'' +
                ", profit=" + profit +
                '}';
    }
}
