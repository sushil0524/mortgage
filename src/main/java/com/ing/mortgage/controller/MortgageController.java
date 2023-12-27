package com.ing.mortgage.controller;
import com.ing.mortgage.model.CheckMortgageResponse;
import com.ing.mortgage.model.InterestRateDTO;
import com.ing.mortgage.model.MortgageCheckRequest;
import com.ing.mortgage.service.MortgageService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
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
    public List<InterestRateDTO> getInterestRates(){
        return mortgageService.getInterestRates();
    }

    @PostMapping(value = "mortgage-check",produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckMortgageResponse checkMortgage(@Valid @RequestBody MortgageCheckRequest mortgageCheckRequest){
       return mortgageService.checkMortgage(mortgageCheckRequest);
    }


}
