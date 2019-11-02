package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned;

public class DepositListReturnModel {

    private Long id;
    private String name;

    public DepositListReturnModel() {
    }

    public DepositListReturnModel(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "DepositListReturnModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
