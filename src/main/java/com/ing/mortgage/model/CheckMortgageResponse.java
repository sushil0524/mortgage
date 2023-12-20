package com.ing.mortgage.model;

public class CheckMortgageResponse {

    Boolean isMortgageFeasible;

    public Boolean getMortgageFeasible() {
        return isMortgageFeasible;
    }

    public void setMortgageFeasible(Boolean mortgageFeasible) {
        isMortgageFeasible = mortgageFeasible;
    }

    public Double getMonthlyMortgageCost() {
        return monthlyMortgageCost;
    }

    public void setMonthlyMortgageCost(Double monthlyMortgageCost) {
        this.monthlyMortgageCost = monthlyMortgageCost;
    }

    Double monthlyMortgageCost;
}
