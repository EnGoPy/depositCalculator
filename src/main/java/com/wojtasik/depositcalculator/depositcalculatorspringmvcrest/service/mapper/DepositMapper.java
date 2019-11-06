package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.DepositEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositResponse;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositReturnedModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositWithCalculationModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class DepositMapper {

    public DepositEntity fromModelToEntity(DepositModel model) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, DepositEntity.class);
    }

    public DepositReturnedModel entityToReturned(DepositEntity depositEntity) {
        ModelMapper modelMapper = new ModelMapper();
        DepositReturnedModel depositReturnedModel = modelMapper.map(depositEntity, DepositReturnedModel.class);
        long depositDuration = ChronoUnit.DAYS.between(depositEntity.getStartDate(), depositEntity.getEndDate());
        depositReturnedModel.setDepositDuration(depositDuration);
        return depositReturnedModel;
    }

    public DepositResponse entityToReturnedAsList(DepositEntity depositEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(depositEntity, DepositResponse.class);
    }

    public DepositWithCalculationModel entityToDepositWithList(DepositEntity depositEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(depositEntity, DepositWithCalculationModel.class);
    }

    public List<DepositResponse> entityListToDepositResponse(List<DepositEntity> depositEntities){
        List<DepositResponse> depositResponses = new ArrayList<>();
        for(DepositEntity entity : depositEntities){
            depositResponses.add(entityToReturnedAsList(entity));
        }
        return depositResponses;
    }



}
