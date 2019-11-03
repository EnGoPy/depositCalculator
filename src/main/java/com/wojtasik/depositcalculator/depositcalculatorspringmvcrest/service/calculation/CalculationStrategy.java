package com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.service.calculation;

import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.dao.entity.DepositEntity;
import com.wojtasik.depositcalculator.depositcalculatorspringmvcrest.web.model.incoming.CalculationModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

@Component
public class CalculationStrategy {

    public BigDecimal currentDayCalculation(DepositEntity deposit, CalculationModel data) {
        if (LocalDate.now().isAfter(deposit.getEndDate()) || deposit.getStartDate().isAfter(LocalDate.now()))
            return new BigDecimal(-1);
        else {
            BigDecimal ownedMoney = data.getAmount();
            int monthsBetween = monthsBetween(deposit.getStartDate(), LocalDate.now());
            int capitalization = deposit.getCapitalization();
            int capitalizationPeriods = monthsBetween / capitalization;
            double periodDepositRate = deposit.getDebitRate() * capitalization / 12;
            for (int i = 1; i <= capitalizationPeriods; i++) {
                ownedMoney = ownedMoney.add(profitCounter(ownedMoney, periodDepositRate));
            }
            return ownedMoney;
        }
    }

    public BigDecimal wholeTermCalculation(DepositEntity deposit, CalculationModel data) {
        BigDecimal ownedMoney = data.getAmount();
        int monthsBetween = monthsBetween(deposit.getStartDate(), deposit.getEndDate());
        int capitalization = deposit.getCapitalization();
        int capitalizationPeriods = monthsBetween / capitalization;
        double periodDepositRate = deposit.getDebitRate() * capitalization / 12;
        for (int i = 1; i <= capitalizationPeriods; i++) {
            ownedMoney = ownedMoney.add(profitCounter(ownedMoney, periodDepositRate));
        }
        return ownedMoney;
    }

    private int monthsBetween(LocalDate earlier, LocalDate later) {
        long months = ChronoUnit.MONTHS.between(YearMonth.from(earlier), YearMonth.from(later));
        return Math.toIntExact(months);
    }

    private BigDecimal profitCounter(BigDecimal basicAmount, double debitRate) {
        BigDecimal percent = BigDecimal.valueOf(debitRate).divide(BigDecimal.valueOf(100));
        return basicAmount.multiply(percent).setScale(2, RoundingMode.HALF_UP);
    }

}
