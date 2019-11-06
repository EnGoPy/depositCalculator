package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CalculationForListModel {

    private BigDecimal amount;
    private LocalDate calculationDate;
    private String algorithmType;
    private BigDecimal profit;

    public CalculationForListModel(BigDecimal amount, LocalDate calculationDate, String algorithmType, BigDecimal profit) {
        this.amount = amount;
        this.calculationDate = calculationDate;
        this.algorithmType = algorithmType;
        this.profit = profit;
    }

}
