package com.ing.mortgage.service;

import com.ing.mortgage.model.CheckMortgageResponse;
import com.ing.mortgage.model.InterestRates;
import com.ing.mortgage.model.MortgageCheckRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MortgageService {

    public List<InterestRates> getInterestRates();

    public CheckMortgageResponse checkMortgage(MortgageCheckRequest mortgageCheckRequest);
}
