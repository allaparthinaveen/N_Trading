package com.nav.algo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.nav.algo.strategy.UpAndDownStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculationUtils {
    private static final Logger logger = LoggerFactory.getLogger(CalculationUtils.class);
    /**
     * Calculate the percentage with of and given number
     * @param of
     * @param number
     * @return (of / 100) * number
     */
    public static BigDecimal percentageOf(final BigDecimal of, final BigDecimal number){
        return (of.divide(new BigDecimal(100))).multiply(number);
    }

    /**
     * change = difference between two prices/values
     * @param one
     * @param two
     * @return (change/original)X100
     */
    public static BigDecimal percentageOfChange(final BigDecimal one, final BigDecimal two){
        BigDecimal change = one.compareTo(two) > 0 ? one.subtract(two) : two.subtract(one);
        BigDecimal original = one.compareTo(two) > 0 ? two : one;

        return change.divide(original, RoundingMode.CEILING).multiply(new BigDecimal(100));
    }

    /**
     * Calculate how many number of asserts has to be sold
     * @param totalAsserts
     * @param assertValue
     * @param totalValue
     * @param sellPercent
     * @return
     */
    public BigDecimal calculateSellAsserts(BigDecimal totalAsserts, BigDecimal assertValue, BigDecimal totalValue,
                                           BigDecimal sellPercent){
        BigDecimal percent = percentageOf(sellPercent, totalValue);

        //Calculate the number of asserts to sold
        BigDecimal noOfAssertsToSold = percent.divide(assertValue, RoundingMode.CEILING);

        //Calculate remaining asserts
        BigDecimal remainingAsserts = totalAsserts.subtract(noOfAssertsToSold);

        logger.info("Number of asserts to be sold: {} ", noOfAssertsToSold);
        logger.info("Remaining asserts after sold: {} ", remainingAsserts);
        return  remainingAsserts;
    }

    /**
     * Calculate how many number of asserts has to be buy
     * @param totalAsserts
     * @param assertValue
     * @param totalValue
     * @param buyPercent
     * @return
     */
    public BigDecimal calculateBuyAsserts(BigDecimal totalAsserts, BigDecimal assertValue, BigDecimal totalValue,
                                           BigDecimal buyPercent){
        BigDecimal percent = percentageOf(buyPercent, totalValue);

        //Calculate the number of asserts to sold
        BigDecimal noOfAssertsToBuy = percent.divide(assertValue, RoundingMode.CEILING);

        //Calculate remaining asserts
        BigDecimal remainingAsserts = totalAsserts.add(noOfAssertsToBuy);

        logger.info("Number of asserts to be buy: {} ", noOfAssertsToBuy);
        logger.info("Remaining asserts after buy: {} ", remainingAsserts);
        return  remainingAsserts;
    }

}
