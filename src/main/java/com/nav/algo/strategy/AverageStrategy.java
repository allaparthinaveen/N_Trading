package com.nav.algo.strategy;

import com.nav.algo.dto.AveragePossibility;
import com.nav.algo.utils.CalculationUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class AverageStrategy {

    /**
     *
     * @param currentInvestment
     * @param currentNumberOfAsserts
     * @param currentAssertWorth
     * @param average
     * @param currentAssertValue
     * @return
     */
    public static List<AveragePossibility> calculateAveragePossibilities(BigDecimal currentInvestment, BigDecimal currentNumberOfAsserts,
                                                                          BigDecimal currentAssertWorth, BigDecimal average, BigDecimal currentAssertValue){
        List<AveragePossibility> possibilities =  new ArrayList<AveragePossibility>();

        AveragePossibility possibility = new AveragePossibility();

        for (BigDecimal i = new BigDecimal(10); i.compareTo(new BigDecimal(90)) < 0; i = i.add(new BigDecimal(10))){
            possibility = new AveragePossibility();

            possibility.setCurrentInvestment(currentInvestment);
            possibility.setCurrentAverageAssertValue(average);
            possibility.setCurrentNumberOfAsserts(currentNumberOfAsserts);
            possibility.setCurrentAssertWorth(currentAssertWorth);
            possibility.setCurrentAssertPrice(currentAssertValue);
            BigDecimal currentProfitOrLoss  = currentAssertWorth.subtract(currentInvestment);
            possibility.setCurrentProfitOrLoss(currentProfitOrLoss);


            //i percentage increase in investment
            BigDecimal newInvestment = CalculationUtils.percentageOf(i, currentProfitOrLoss);
            possibility.setNewInvestment(newInvestment);

            //calculate new number of asserts
            BigDecimal additionalAsserts = newInvestment.divide(currentAssertValue, RoundingMode.CEILING);
            possibility.setAdditionalAssertsToBeRaised(additionalAsserts);

            //total asserts after additional purchase
            BigDecimal updatedTotalAsserts = currentNumberOfAsserts.add(additionalAsserts);
            possibility.setUpdatedNumberOfAsserts(updatedTotalAsserts);

            //Updated total asserts worth
            BigDecimal updatedTotalAssertWorth = updatedTotalAsserts.multiply(currentAssertValue);
            possibility.setUpdatedAssertWorth(updatedTotalAssertWorth.setScale(2, BigDecimal.ROUND_HALF_EVEN));

            //updated average
            BigDecimal updatedAverage = (currentInvestment.add(newInvestment)).divide(currentAssertValue, RoundingMode.CEILING);
            possibility.setUpdatedAverageAssertValue(updatedAverage);

            possibility.setUpdatedProfitOrLoss(possibility.getUpdatedAssertWorth().subtract(possibility.getUpdatedInvestment()));
            possibility.setUpdatedChangePercentage(CalculationUtils.percentageOfChange(possibility.getUpdatedAssertWorth(), possibility.getUpdatedInvestment()));

            possibilities.add(possibility);
        }

        return possibilities;
    }


}
