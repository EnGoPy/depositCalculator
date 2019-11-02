package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class CalculationModel {

    @Min(0)
    private BigDecimal amount;
    @Valid()
    private String calculationType;

    public CalculationModel() {
    }

    public CalculationModel(BigDecimal amount, String calculationType) {
        this.amount = amount;
        this.calculationType = calculationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    @Override
    public String toString() {
        return "CalculationModel{" +
                "amount=" + amount +
                ", calculationType='" + calculationType + '\'' +
                '}';
    }
}
