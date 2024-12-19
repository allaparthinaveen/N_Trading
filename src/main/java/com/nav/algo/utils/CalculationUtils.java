package com.nav.algo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.nav.algo.dto.UpDownLog;
import com.nav.algo.strategy.UpAndDownStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculationUtils {
    private static final Logger logger = LoggerFactory.getLogger(CalculationUtils.class);

    /**
     * Calculate the percentage with of and given number
     *
     * @param of
     * @param number
     * @return (of / 100) * number
     */
    public static BigDecimal percentageOf(final BigDecimal of, final BigDecimal number) {
        return (of.divide(new BigDecimal(100))).multiply(number);
    }

    /**
     * change = difference between two prices/values
     *
     * @param one
     * @param two
     * @return (change / original)X100
     */
    public static BigDecimal percentageOfChange(BigDecimal one, BigDecimal two) {
        BigDecimal change = two.subtract(one);
        return change.divide(one, 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
    }

    /**
     *
     * @param asserts
     * @param sellValue
     * @param currentAssertValue
     * @param row
     * @return currentAsserts - percentageOfAssertsToBeSold
     */
    public BigDecimal calculateNo0fAssertsToSell(BigDecimal asserts, BigDecimal sellValue, BigDecimal currentAssertValue, UpDownLog row) {
        //Calculate the number of asserts to sold
        BigDecimal assertsSold = sellValue.divide(currentAssertValue, 4, RoundingMode.HALF_UP);
        //Calculate the remaining asserts
        BigDecimal remainingAsserts = asserts.subtract(assertsSold);
        row.setNumberOfAssertToBuy(BigDecimal.ZERO);
        row.setNumberOfAssertToSell(assertsSold);
        row.setCurrentNumberOfAsserts(remainingAsserts);
        return remainingAsserts;
    }

    /**
     *
     * @param asserts
     * @param buyValue
     * @param currentAssertValue
     * @param row
     * @return currentAsserts + percentageOfAssertsToBuy
     */
    public BigDecimal calculateNo0fAssertsToBuy(BigDecimal asserts, BigDecimal buyValue, BigDecimal currentAssertValue, UpDownLog row) {
        //Calculate the number of asserts to sold
        BigDecimal assertsToBuy = buyValue.divide(currentAssertValue, 4, RoundingMode.HALF_UP);
        //Calculate the remaining asserts
        BigDecimal remainingAsserts = asserts.add(assertsToBuy);
        row.setNumberOfAssertToSell(BigDecimal.ZERO);
        row.setNumberOfAssertToBuy(assertsToBuy);
        row.setCurrentNumberOfAsserts(remainingAsserts);
        return remainingAsserts;
    }

}
