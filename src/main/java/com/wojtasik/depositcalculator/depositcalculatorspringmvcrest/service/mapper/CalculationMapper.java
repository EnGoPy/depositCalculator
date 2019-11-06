package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.CalculationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CalculationMapper {

    public CalculationResponse fromEntityToReturnModel(CalculationEntity entity) {
        if (entity != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(entity, CalculationResponse.class);
        }
        return null;
    }

}
