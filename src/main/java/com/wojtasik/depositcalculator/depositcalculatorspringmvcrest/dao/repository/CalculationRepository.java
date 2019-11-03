package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.repository;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<CalculationEntity, Long> {


}
