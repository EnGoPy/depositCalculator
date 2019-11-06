package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositReturnedModel {

    private Long id;
    private String name;
    private double debitRate;
    private long depositDuration;

}
