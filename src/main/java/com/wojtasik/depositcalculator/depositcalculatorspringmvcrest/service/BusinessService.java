package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.DepositEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.DepositNotFoundException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.exception.FutureDateException;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.calculation.CalculationStrategy;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper.CalculationMapper;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper.DepositMapper;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.CalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.CalculationReturnModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositListReturnModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositReturnedModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositWithCalculationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private DepositService depositService;
    @Autowired
    private CalculationService calculationService;
    @Autowired
    private DepositMapper depositMapper;
    @Autowired
    private CalculationMapper calculationMapper;
    @Autowired
    private CalculationStrategy calculationStrategy;

    public List<DepositListReturnModel> list() {
        List<DepositEntity> list;
        list = depositService.listAll();
        System.out.println(list.size());
        if (list.size() > 0) {
            List<DepositListReturnModel> depositReturnedModels = new ArrayList<>();
            for (DepositEntity entity : list) {
                depositReturnedModels.add(depositMapper.entityToReturnedAsList(entity));
            }
            return depositReturnedModels;
        }
        return null;
    }

    public DepositReturnedModel addDeposit(DepositModel depositModel) {
        DepositEntity entityToBeAdded = depositMapper.fromModelToEntity(depositModel);
        DepositEntity createdModel = depositService.save(entityToBeAdded);
        return depositMapper.entityToReturned(createdModel);
    }

    @Transactional
    public Optional<CalculationReturnModel> calculateProfit(Long depositId, CalculationModel calculationModel) {
        Optional<DepositEntity> depositModel = depositService.get(depositId);
        if (depositModel.isPresent()) {
            DepositEntity deposit = depositModel.get();
            CalculationEntity createdEntity = calculateByStrategy(deposit, calculationModel);
            if (createdEntity != null) {
                return Optional.of(calculationMapper.fromEntityToReturnModel(createdEntity));
            } else {
                throw new FutureDateException();
            }

        }
        throw new DepositNotFoundException(depositId);
    }

    private CalculationEntity calculateByStrategy(DepositEntity deposit, CalculationModel calculationModel) throws FutureDateException {
        BigDecimal savings = new BigDecimal(0);
        System.out.println(deposit);
        if (calculationModel.getCalculationType().equals("current")) {
            savings = calculationStrategy.currentDayCalculation(deposit, calculationModel);
        } else if (calculationModel.getCalculationType().equals("whole")) {
            savings = calculationStrategy.wholeTermCalculation(deposit, calculationModel);
        }
        if (savings.intValue() != -1) {
            BigDecimal profit = savings.subtract(calculationModel.getAmount()).setScale(2, RoundingMode.HALF_UP);
            CalculationEntity calculationEntity = new CalculationEntity(calculationModel.getAmount(), LocalDate.now(), calculationModel.getCalculationType(), profit);
            CalculationEntity createdEntity = calculationService.save(calculationEntity);
            deposit.addCalculation(createdEntity);
            deposit.increaseCalculationCounter();
            return createdEntity;
        } else {
            return null;
        }
    }


    public Optional<DepositWithCalculationModel> getDepositWithCalculations(Long id) {
        Optional<DepositEntity> deposit = depositService.get(id);
        if (deposit.isPresent()) {
            DepositWithCalculationModel mappedValue = depositMapper.entityToDepositWithList(deposit.get());
            return Optional.of(mappedValue);
        }
        return Optional.empty();

    }
}
