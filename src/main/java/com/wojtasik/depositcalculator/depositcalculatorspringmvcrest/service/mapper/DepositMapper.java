package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.DepositEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositWithCalculationModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositListReturnModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.returned.DepositReturnedModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
public class DepositMapper {

    public DepositModel fromEntityToModel(DepositEntity entity){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(entity, DepositModel.class);
    }

    public DepositEntity fromModelToEntity(DepositModel model){
            ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, DepositEntity.class);
    }

    public DepositReturnedModel entityToReturned(DepositEntity depositEntity){
            ModelMapper modelMapper = new ModelMapper();
            DepositReturnedModel depositReturnedModel = modelMapper.map(depositEntity, DepositReturnedModel.class);
            long depositDuration = ChronoUnit.DAYS.between(depositEntity.getEndDate(), depositEntity.getStartDate());
            depositReturnedModel.setDepositDuration(depositDuration);
            return depositReturnedModel;
    }

    public DepositListReturnModel entityToReturnedAsList(DepositEntity depositEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(depositEntity, DepositListReturnModel.class);
    }

    public DepositWithCalculationModel entityToDepositWithList(DepositEntity depositEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(depositEntity, DepositWithCalculationModel.class);
    }



}
