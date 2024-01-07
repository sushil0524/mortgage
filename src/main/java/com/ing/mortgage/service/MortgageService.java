package com.ing.mortgage.service;

import com.ing.mortgage.model.CheckMortgageResponse;
import com.ing.mortgage.model.InterestRateDTO;
import com.ing.mortgage.model.MortgageCheckRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MortgageService {

    public List<InterestRateDTO> getInterestRates();

    public CheckMortgageResponse checkMortgage(MortgageCheckRequest mortgageCheckRequest);
}
