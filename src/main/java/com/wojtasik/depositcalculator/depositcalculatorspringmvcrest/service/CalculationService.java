package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculationService {

    @Autowired
    private CalculationRepository calculationRepository;


    public List<CalculationEntity> listAll(){
        return calculationRepository.findAll();
    }

    public CalculationEntity save(CalculationEntity entity){
        return calculationRepository.save(entity);
    }

    public Optional<CalculationEntity> get(Long id){
        return calculationRepository.findById(id);
    }


}
