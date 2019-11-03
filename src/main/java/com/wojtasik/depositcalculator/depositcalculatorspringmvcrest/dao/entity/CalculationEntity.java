package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "calculations")
@Data
@NoArgsConstructor
public class CalculationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @Column(name = "calculation_date")
    private LocalDate calculationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id")
    private DepositEntity deposit;

    @Column(name = "algorithm_type")
    private String algorithmType;
    private BigDecimal profit;


    public CalculationEntity(BigDecimal amount, LocalDate calculationDate, String algorithmType, BigDecimal profit) {
        this.amount = amount;
        this.calculationDate = calculationDate;
        this.algorithmType = algorithmType;
        this.profit = profit;
    }

    public CalculationEntity(BigDecimal amount, LocalDate calculationDate, DepositEntity deposit, String algorithmType, BigDecimal profit) {
        this.amount = amount;
        this.calculationDate = calculationDate;
        this.deposit = deposit;
        this.algorithmType = algorithmType;
        this.profit = profit;
    }

}
