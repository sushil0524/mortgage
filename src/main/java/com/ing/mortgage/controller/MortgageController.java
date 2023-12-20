package com.ing.mortgage.controller;


import com.ing.mortgage.model.InterestRates;
import com.ing.mortgage.model.MortgageCheckRequest;
import com.ing.mortgage.model.CheckMortgageResponse;
import com.ing.mortgage.service.MortgageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MortgageController {

    private final MortgageService mortgageService;

    public MortgageController(MortgageService mortgageService) {
        this.mortgageService = mortgageService;
    }


    @GetMapping("interest-rates")
    public List<InterestRates> getInterestRates(){

       return mortgageService.getInterestRates();


    }

    @PostMapping("mortgage-check")
    public CheckMortgageResponse checkMortgage(@Valid @RequestBody MortgageCheckRequest mortgageCheckRequest){


        return mortgageService.checkMortgage(mortgageCheckRequest);


    }


}
