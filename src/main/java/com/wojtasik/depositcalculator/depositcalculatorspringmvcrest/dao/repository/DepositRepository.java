package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.repository;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<DepositEntity, Long> {
}
