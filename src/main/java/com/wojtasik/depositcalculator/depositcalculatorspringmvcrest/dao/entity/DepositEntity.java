package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deposit")

@Data
@NoArgsConstructor
public class DepositEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "debit_rate")
    private double debitRate;
    private int capitalization;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @OneToMany(
            mappedBy = "deposit",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<CalculationEntity> calculations = new ArrayList<>();
    @Column(name = "calculation_counter")
    private Integer calculationCounter = 0;


    public DepositEntity(String name, double debitRate, int capitalization, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.debitRate = debitRate;
        this.capitalization = capitalization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.calculations = new ArrayList<>();
    }

    public void addCalculation(CalculationEntity entity) {
        this.calculations.add(entity);
        entity.setDeposit(this);
    }

    public void removeCalculation(CalculationEntity entity) {
        this.calculations.remove(entity);
        entity.setDeposit(null);
    }


    public void increaseCalculationCounter() {
        this.calculationCounter = +1;
    }

}
