package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="deposit")
public class DepositEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="debit_rate")
    private double debitRate;
    private int capitalization;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
    @OneToMany(
            mappedBy = "deposit",
            cascade = {CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH} )
    private List<CalculationEntity> calculations = new ArrayList<>();
    @Column(name="calculation_counter")
    private Integer calculationCounter=0;

    public DepositEntity() {
    }

    public DepositEntity(String name, double debitRate, int capitalization, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.debitRate = debitRate;
        this.capitalization = capitalization;
        this.startDate = startDate;
        this.endDate = endDate;
        this.calculations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDebitRate() {
        return debitRate;
    }

    public void setDebitRate(double debitRate) {
        this.debitRate = debitRate;
    }

    public int getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(int capitalization) {
        this.capitalization = capitalization;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<CalculationEntity> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<CalculationEntity> calculations) {
        this.calculations = calculations;
    }

    public void addCalculation(CalculationEntity entity){
        this.calculations.add(entity);
        entity.setDeposit(this);
    }

    public void removeCalculation(CalculationEntity entity){
        this.calculations.remove(entity);
        entity.setDeposit(null);
    }

    public Integer getCalculationCounter() {
        return calculationCounter;
    }

    public void setCalculationCounter(Integer calculationCounter) {
        this.calculationCounter = calculationCounter;
    }

    public void increaseCalculationCounter(){
        this.calculationCounter=+1;
    }


    @Override
    public String toString() {
        return "DepositEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", debitRate=" + debitRate +
                ", capitalization=" + capitalization +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
