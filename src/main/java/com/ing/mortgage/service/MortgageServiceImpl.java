package com.ing.mortgage.service;

import com.ing.mortgage.model.CheckMortgageResponse;
import com.ing.mortgage.model.InterestRates;
import com.ing.mortgage.model.MortgageCheckRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MortgageServiceImpl implements  MortgageService{
    /**
     * @return
     */
    @Override
    public List<InterestRates> getInterestRates() {

        return null;
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
