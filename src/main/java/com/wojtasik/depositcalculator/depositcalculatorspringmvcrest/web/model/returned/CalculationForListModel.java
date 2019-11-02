package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculationForListModel {

    private BigDecimal amount;
    private LocalDate calculationDate;
    private String algorithmType;
    private BigDecimal profit;

    public CalculationForListModel() {
    }

    public CalculationForListModel(BigDecimal amount, LocalDate calculationDate, String algorithmType, BigDecimal profit) {
        this.amount = amount;
        this.calculationDate = calculationDate;
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
        return "CalculationForListModel{" +
                "amount=" + amount +
                ", calculationDate=" + calculationDate +
                ", algorithmType='" + algorithmType + '\'' +
                ", profit=" + profit +
                '}';
    }
}
