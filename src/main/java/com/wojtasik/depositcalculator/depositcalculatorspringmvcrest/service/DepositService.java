package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service;


import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.DepositEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.repository.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;


    public List<DepositEntity> listAll(){
        return depositRepository.findAll();
    }

    public DepositEntity save(DepositEntity entity){
        return depositRepository.save(entity);
    }

    public Optional<DepositEntity> get(Long id){
        return depositRepository.findById(id);
    }


}
