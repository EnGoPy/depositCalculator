package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.controller;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.DepositNotFoundException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.FutureDateException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.BusinessService;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositWithCalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.CalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.CalculationReturnModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositListReturnModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositReturnedModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class InvestmentsController {

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/investments" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<DepositListReturnModel> availableDeposits(Model model){
        return businessService.list();
    }

    @PostMapping("/investments")
    public DepositReturnedModel addNewDeposit(@Valid @RequestBody DepositModel depositModel,
                                              BindingResult bindingResult){
        System.out.println(depositModel.toString());
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return null;
        }else {
            return businessService.addDeposit(depositModel);
        }
    }

    @PostMapping(value = "/investments/{id}/calculations", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CalculationReturnModel calculationOfDeposit(@PathVariable Long id, @RequestBody CalculationModel calculationModel){
        System.out.println("======== POST CALCULATION ========");
        System.out.println("Received id "+id);
        System.out.println("Received calculationModel: "+calculationModel);
        try {
//            return businessService.calculateProfit(id, calculationModel).orElseThrow(() -> );
            return businessService.calculateProfit(id, calculationModel).get();
        }catch (DepositNotFoundException | FutureDateException ex){
           throw new RuntimeException(ex);
        }
    }

    @GetMapping(value = "/investments/{id}/calculations", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DepositWithCalculationModel depositWithAllCalculations(@PathVariable Long id) {
        System.out.println("======== GET CALCULATION OF SPECIFIC DEPOSIT ========");
//        DepositWithCalculationModel model = businessService.getDepositWithCalculations(id);
        return businessService.getDepositWithCalculations(id).orElseThrow(() -> new DepositNotFoundException(id));
    }


}
