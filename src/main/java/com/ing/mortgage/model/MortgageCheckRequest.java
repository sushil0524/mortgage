package com.ing.mortgage.model;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;

public class MortgageCheckRequest {

    @NotNull(message="Income is required")
    BigDecimal income;

    @NotNull(message = "Maturity Period is required")
    Integer maturityPeriod;

    @NotNull(message = "Loan Amount is required")
    Double loanValue;

    @NotNull(message = "Home Value is required")
    Double homeValue;
    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Integer getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(Integer maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public Double getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(Double loanValue) {
        this.loanValue = loanValue;
    }

    public Double getHomeValue() {
        return homeValue;
    }

    public void setHomeValue(Double homeValue) {
        this.homeValue = homeValue;
    }



}
