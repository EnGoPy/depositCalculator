package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.controller;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.DepositNotFoundException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.FutureDateException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.BusinessService;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.CalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.CalculationResponse;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositResponse;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositReturnedModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositWithCalculationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class InvestmentsController {

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/investments")
    public List<DepositResponse> availableDeposits() {
        return businessService.list();
    }

    @PostMapping("/investments")
    public DepositReturnedModel addNewDeposit(@RequestBody DepositModel depositModel) { //Binding results
        return businessService.addDeposit(depositModel);
    }

    @PostMapping(value = "/investments/{id}/calculations")
    public CalculationResponse calculationOfDeposit(@PathVariable Long id, @RequestBody CalculationModel calculationModel) {
        return businessService.calculateProfit(id, calculationModel).orElseThrow(FutureDateException::new);
    }

    @GetMapping(value = "/investments/{id}/calculations")
    public DepositWithCalculationModel depositWithAllCalculations(@PathVariable Long id) {
        return businessService.getDepositWithCalculations(id).orElseThrow(() -> new DepositNotFoundException(id));
    }



}
