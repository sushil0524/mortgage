package com.ing.mortgage.model;

public class CheckMortgageResponse {

    Boolean isMortgageFeasible;
    Double monthlyMortgageCost;

    public void setMortgageFeasible(Boolean mortgageFeasible) {
        isMortgageFeasible = mortgageFeasible;
    }

    public void setMonthlyMortgageCost(Double monthlyMortgageCost) {
        this.monthlyMortgageCost = monthlyMortgageCost;
    }

    public CheckMortgageResponse() {
    }

    public CheckMortgageResponse(Boolean isMortgageFeasible, Double monthlyMortgageCost) {
        this.isMortgageFeasible = isMortgageFeasible;
        this.monthlyMortgageCost = monthlyMortgageCost;
    }

    public Boolean getMortgageFeasible() {
        return isMortgageFeasible;
    }

    public Double getMonthlyMortgageCost() {
        return monthlyMortgageCost;
    }
}
