package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationModel {

    @Min(0)
    private BigDecimal amount;
    private String calculationType;

}
