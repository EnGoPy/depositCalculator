package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.repository.CalculationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculationService {

    @Autowired
    private CalculationRepository calculationRepository;

    public CalculationEntity save(CalculationEntity entity) {
        return calculationRepository.save(entity);
    }

}
