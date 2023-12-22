package com.ing.mortgage.service;

import com.ing.mortgage.model.CheckMortgageResponse;
import com.ing.mortgage.model.InterestRates;
import com.ing.mortgage.model.MortgageCheckRequest;
import com.ing.mortgage.repository.InterestRatesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MortgageServiceImpl implements  MortgageService{

    private final InterestRatesRepository interestRatesRepository;

    public MortgageServiceImpl(InterestRatesRepository interestRatesRepository) {
        this.interestRatesRepository = interestRatesRepository;
    }

    /**
     * @return
     */
    @Override
    public List<InterestRates> getInterestRates() {
        return interestRatesRepository.findAll();
    }

    /**
     * @param mortgageCheckRequest
     * @return
     */
    @Override
    public CheckMortgageResponse checkMortgage(MortgageCheckRequest mortgageCheckRequest) {

        CheckMortgageResponse checkMortgageResponse= new CheckMortgageResponse();
        if(mortgageCheckRequest.getLoanValue() > (mortgageCheckRequest.getIncome().doubleValue() * 4)) {
            checkMortgageResponse.setMortgageFeasible(Boolean.FALSE);

        }
        else if (mortgageCheckRequest.getLoanValue()> mortgageCheckRequest.getHomeValue()){
            checkMortgageResponse.setMortgageFeasible(Boolean.FALSE);
        }
        return checkMortgageResponse;
    }
}
