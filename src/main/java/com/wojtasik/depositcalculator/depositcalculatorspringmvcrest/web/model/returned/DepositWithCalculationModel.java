package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositWithCalculationModel {

    private Long id;
    private String name;
    private double debitRate;
    private int capitalization;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<CalculationForListModel> calculations = new ArrayList<>();

    public DepositWithCalculationModel(Long id, String name, double debitRate, int capitalization, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.debitRate = debitRate;
        this.capitalization = capitalization;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
