package com.ing.mortgage.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table
public class InterestRates {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    Integer maturityPeriod;
    Double  interestRate;

    public InterestRates(Integer id, Integer maturityPeriod, Double interestRate) {
        this.id = id;
        this.maturityPeriod = maturityPeriod;
        this.interestRate = interestRate;
    }

    public InterestRates() {

    }

    public Integer getMaturityPeriod() {
        return maturityPeriod;
    }

    public void setMaturityPeriod(Integer maturityPeriod) {
        this.maturityPeriod = maturityPeriod;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


}
