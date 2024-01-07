package com.ing.mortgage.service;
import com.ing.mortgage.exceptions.InterestRateNotFoundException;
import com.ing.mortgage.model.*;
import com.ing.mortgage.repository.InterestRatesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.Math.pow;
@Service
public class MortgageServiceImpl implements MortgageService {
    private final InterestRatesRepository interestRatesRepository;
    private final InterestRateDTOMapper interestRateDTOMapper;
    public MortgageServiceImpl(InterestRatesRepository interestRatesRepository,
                               InterestRateDTOMapper interestRateDTOMapper) {
        this.interestRatesRepository = interestRatesRepository;
        this.interestRateDTOMapper = interestRateDTOMapper;
    }
    /**
     * @return
     */
    @Override
    public List<InterestRateDTO> getInterestRates() {
        return interestRatesRepository.findAll()
                .stream()
                .map(interestRateDTOMapper)
                .collect(Collectors.toList());
    }
    /**
     * @param mortgageCheckRequest
     * @return
     */
    @Override
    public CheckMortgageResponse checkMortgage(MortgageCheckRequest mortgageCheckRequest) {
        Double monthlyEMI;
        CheckMortgageResponse checkMortgageResponse = new CheckMortgageResponse();
        if (mortgageCheckRequest.getLoanValue() > (mortgageCheckRequest.getIncome().doubleValue() * 4)
                && mortgageCheckRequest.getLoanValue() > mortgageCheckRequest.getHomeValue()) {
            checkMortgageResponse.setMortgageFeasible(Boolean.FALSE);
        }
        else {
            checkMortgageResponse.setMortgageFeasible(Boolean.TRUE);
            InterestRate interestRate = interestRatesRepository
                    .findById(mortgageCheckRequest.getMaturityPeriod())
                    .orElseThrow(() -> new InterestRateNotFoundException("Requested Resource Not found"));
            monthlyEMI = mortgageCalculator(mortgageCheckRequest.getLoanValue(), interestRate.getInterestRate(), mortgageCheckRequest.getMaturityPeriod());
            checkMortgageResponse.setMonthlyMortgageCost(monthlyEMI);
        }
        return checkMortgageResponse;
    }

    private static Double mortgageCalculator(Double principalAmount, Double rateOfInterest, Integer loanTenure) {
        double monthlyCost;
        Double monthlyRateOfInterest = rateOfInterest / (12 * 100); // one-month interest
        int monthlyLoanTenure = loanTenure * 12; // one-month period
        monthlyCost = (principalAmount * monthlyRateOfInterest * pow(1 + monthlyRateOfInterest, monthlyLoanTenure)) / (pow(1 + monthlyRateOfInterest, monthlyLoanTenure) - 1);
        return monthlyCost;
    }
}
