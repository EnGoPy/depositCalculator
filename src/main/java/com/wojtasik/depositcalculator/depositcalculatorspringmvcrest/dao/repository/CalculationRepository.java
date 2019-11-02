package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.repository;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.CalculationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<CalculationEntity, Long> {

//    @Quer("SELECT * FROM calculations c where c.deposit_id IN (?1)")
//    List<CalculationEntity> findCalculationsByDepositId(Long id);


}
