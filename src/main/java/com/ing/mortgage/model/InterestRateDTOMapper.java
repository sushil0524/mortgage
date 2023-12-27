package com.ing.mortgage.model;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InterestRateDTOMapper implements Function<InterestRates, InterestRateDTO> {
    @Override
    public InterestRateDTO apply(InterestRates interestRates) {
        return new InterestRateDTO(
                interestRates.getInterestRate()
        );
    }
}
