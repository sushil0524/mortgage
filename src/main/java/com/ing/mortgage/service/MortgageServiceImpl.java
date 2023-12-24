package com.ing.mortgage.service;

import com.ing.mortgage.model.CheckMortgageResponse;
import com.ing.mortgage.model.InterestRates;
import com.ing.mortgage.model.MortgageCheckRequest;
import com.ing.mortgage.repository.InterestRatesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.pow;

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

        Double monthlyEMI=null;
        CheckMortgageResponse checkMortgageResponse= new CheckMortgageResponse();
        if(mortgageCheckRequest.getLoanValue() > (mortgageCheckRequest.getIncome().doubleValue() * 4)
                && mortgageCheckRequest.getLoanValue() > mortgageCheckRequest.getHomeValue()) {
            checkMortgageResponse.setMortgageFeasible(Boolean.FALSE);
        }
        Double rateOfInterest= null;
        List<InterestRates> interestRatesList= interestRatesRepository.findAll();
        for  (InterestRates i : interestRatesList ){
              if (Objects.equals(mortgageCheckRequest.getMaturityPeriod(), i.getMaturityPeriod())){
                  rateOfInterest=i.getInterestRate();
                  break;
              }
        }
        monthlyEMI = mortgageCalculator(mortgageCheckRequest.getHomeValue(), rateOfInterest, mortgageCheckRequest.getMaturityPeriod());
        checkMortgageResponse.setMonthlyMortgageCost(monthlyEMI);
        return checkMortgageResponse;
    }

    private  static Double mortgageCalculator(Double principalAmount, Double rateOfInterest, Integer loanTenure){
        Double monthlyEMI =null;
        Double monthlyRateOfInterest = rateOfInterest / (12 * 100); // one month interest
        int monthlyLoanTenure = loanTenure * 12; // one month period
        monthlyEMI = (principalAmount * monthlyRateOfInterest * pow(1 + monthlyRateOfInterest, monthlyLoanTenure)) / (pow(1 + monthlyRateOfInterest, monthlyLoanTenure) - 1);
        return monthlyEMI;
    }
}
