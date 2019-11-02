package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NamedQuery(name="calculationsByDepositId", query="FROM CalculationEntity WHERE deposit_id = ?1")
@Table(name="calculations")
public class CalculationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @Column(name="calculation_date")
    private LocalDate calculationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id")
    private DepositEntity deposit;

    @Column(name="algorithm_type")
    private String algorithmType;
    private BigDecimal profit;


    public CalculationEntity() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public DepositEntity getDeposit() {
        return deposit;
    }

    public void setDeposit(DepositEntity deposit) {
        this.deposit = deposit;
    }


    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof CalculationEntity)) return false;
        return id != null && id.equals(((CalculationEntity) obj).getId());
    }

    @Override
    public String toString() {
        return "CalculationEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", calculationDate=" + calculationDate +
                ", deposit=" + deposit +
                ", algorithmType='" + algorithmType + '\'' +
                ", profit=" + profit +
                '}';
    }
}
