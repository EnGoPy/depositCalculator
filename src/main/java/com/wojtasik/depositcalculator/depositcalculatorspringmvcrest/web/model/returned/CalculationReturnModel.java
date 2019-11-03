package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationReturnModel {

    private BigDecimal amount;
    private LocalDate calculationDate;
    private String depositName;
    private String algorithmType;
    private BigDecimal profit;


}
