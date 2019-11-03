package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.controller;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.DepositNotFoundException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.FutureDateException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.InvalidInputException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.BusinessService;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.CalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.CalculationReturnModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositListReturnModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositReturnedModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositWithCalculationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class InvestmentsController {

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/investments", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<DepositListReturnModel> availableDeposits(Model model) {
        return businessService.list();
    }

    @PostMapping("/investments")
    public DepositReturnedModel addNewDeposit(@RequestBody DepositModel depositModel,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidInputException();
        } else {
            return businessService.addDeposit(depositModel);
        }
    }

    @PostMapping(value = "/investments/{id}/calculations", produces = {MediaType.APPLICATION_JSON_VALUE})
    public CalculationReturnModel calculationOfDeposit(@PathVariable Long id, @RequestBody CalculationModel calculationModel) {
        try {
            return businessService.calculateProfit(id, calculationModel).get();
        } catch (DepositNotFoundException | FutureDateException ex) {
            throw new RuntimeException(ex);
        }
    }

    @GetMapping(value = "/investments/{id}/calculations", produces = {MediaType.APPLICATION_JSON_VALUE})
    public DepositWithCalculationModel depositWithAllCalculations(@PathVariable Long id) {
        return businessService.getDepositWithCalculations(id).orElseThrow(() -> new DepositNotFoundException(id));
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, true));
    }

}
