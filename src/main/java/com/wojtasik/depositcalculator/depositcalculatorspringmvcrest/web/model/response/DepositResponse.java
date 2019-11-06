package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositResponse {

    private Long id;
    private String name;

}
