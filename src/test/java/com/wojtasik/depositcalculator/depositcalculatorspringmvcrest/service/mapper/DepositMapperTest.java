package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.DepositEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.DepositModel;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.DepositReturnedModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class DepositMapperTest {

    private DepositMapper depositMapper;

    @BeforeEach
    public void setUp() {
        depositMapper = new DepositMapper();
    }

    @Test
    public void givenDepositModel_whenMappedToDepositEntity_thenMappedValuesEqual() {
        // given
        DepositModel depositModel = new DepositModel();
        depositModel.setName("Deposit_1");
        depositModel.setDebitRate(12.5);
        depositModel.setCapitalization(3);
        depositModel.setStartDate(LocalDate.of(2019, 1, 1));
        depositModel.setEndDate(LocalDate.of(2020, 1, 1));
        // when
        DepositEntity mappedEntity = depositMapper.fromModelToEntity(depositModel);
        // then
        assertThat(depositModel).isEqualToComparingOnlyGivenFields(mappedEntity, "name", "debitRate", "capitalization", "startDate", "endDate");
    }

    @Test
    public void givenDepositEntity_whenMappedToDepositReturnedModel_thenMappedValuesEqual() {
        //given
        DepositEntity depositEntity = new DepositEntity("Deposit_1", 12.5, 3, LocalDate.of(2019, 1, 1), LocalDate.of(2020, 1, 1));
        //when
        DepositReturnedModel returnedModel = depositMapper.entityToReturned(depositEntity);
        //then
        assertThat(depositEntity).isEqualToComparingOnlyGivenFields(returnedModel, "name", "debitRate");
    }


}