package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned;

public class DepositReturnedModel {

    private Long id;
    private String name;
    private double debitRate;
    private long depositDuration;

    public DepositReturnedModel() {
    }

    public DepositReturnedModel(Long id, String name, double debitRate, int depositDuration) {
        this.id = id;
        this.name = name;
        this.debitRate = debitRate;
        this.depositDuration = depositDuration;
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

    public long getDepositDuration() {
        return depositDuration;
    }

    public void setDepositDuration(long depositDuration) {
        this.depositDuration = depositDuration;
    }

    @Override
    public String toString() {
        return "DepositReturnedModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", debitRate=" + debitRate +
                ", depositDuration=" + depositDuration +
                '}';
    }
}
