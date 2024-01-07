package com.ing.mortgage.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InterestRateDTOMapper implements Function<InterestRate, InterestRateDTO> {
    @Override
    public InterestRateDTO apply(InterestRate interestRate) {
        return new InterestRateDTO(
                interestRate.getInterestRate(),
                interestRate.getMaturityPeriod()
        );
    }
}
