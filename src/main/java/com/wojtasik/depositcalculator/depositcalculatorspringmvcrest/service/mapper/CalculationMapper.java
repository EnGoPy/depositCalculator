package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.CalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.CalculationReturnModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CalculationMapper {

    public CalculationReturnModel fromEntityToReturnModel(CalculationEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CalculationReturnModel.class);
    }

    public CalculationEntity fromModelToEntity(CalculationModel model) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, CalculationEntity.class);
    }

}
