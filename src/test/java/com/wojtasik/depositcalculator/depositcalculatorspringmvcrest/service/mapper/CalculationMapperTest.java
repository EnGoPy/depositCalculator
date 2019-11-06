package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.mapper;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.response.CalculationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationMapperTest {

    private CalculationMapper calculationMapper;

    @BeforeEach
    public void setUp() {
        calculationMapper = new CalculationMapper();
    }

    @Test
    void givenValidCalculationEntity_whenMapped_thenValidCalculationReturnModel() {
        // given
        CalculationEntity calculationEntity = new CalculationEntity(new BigDecimal(100), LocalDate.of(2000, 1, 1), "whole", new BigDecimal(100));
        CalculationResponse mappedModel;
        // when
        mappedModel = calculationMapper.fromEntityToReturnModel(calculationEntity);
        // then
        assertThat(mappedModel).isEqualToComparingOnlyGivenFields(calculationEntity, "amount", "calculationDate", "algorithmType", "profit");
    }

    @Test
    void givenNullCalculationEntity_whenMapped_thenNullCalculationReturnModel() {
        // given
        CalculationEntity calculationEntity = null;
        CalculationResponse mappedModel;
        // when
        mappedModel = calculationMapper.fromEntityToReturnModel(calculationEntity);
        // then
        assertThat(mappedModel).isNull();
    }

}