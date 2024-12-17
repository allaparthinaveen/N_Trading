package com.nav.algo.strategy;

import com.nav.algo.dto.HistoricalData;
import com.nav.algo.utils.CalculationUtils;
import com.nav.algo.utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UpAndDownStrategy {
    private static final Logger logger = LoggerFactory.getLogger(UpAndDownStrategy.class);

    public void testStrategy(final BigDecimal entryAmount, final BigDecimal entryValue,
                             final BigDecimal buyPercent, final BigDecimal sellPercent, BigDecimal numberOfAsserts){
        logger.info("testStrategy :: start ..");
        String excelFilePath = "sol.xlsx";
        List<BigDecimal> buying = new ArrayList<>();
        List<BigDecimal> selling = new ArrayList<>();
        CalculationUtils calculations = new CalculationUtils();
        ExcelUtils excelUtils = new ExcelUtils();

        try{
            List<HistoricalData> hData = excelUtils.getData(excelFilePath);
            //Sort the data order by date in case
            Collections.sort(hData);
            for (HistoricalData data : hData){
                BigDecimal currentAssertValue = BigDecimal.valueOf(data.getClose());
                BigDecimal currentValue = currentAssertValue.multiply(numberOfAsserts);
                logger.info("Total asserts : {} && Current value : {} ",numberOfAsserts, currentValue);
                BigDecimal percentageDiff = currentValue.subtract(entryAmount).divide(entryAmount, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
                logger.info("percentageDiff : {} ", percentageDiff);

                if(currentValue.compareTo(entryAmount) > 0 && percentageDiff.compareTo(sellPercent) > 0){
                    BigDecimal sellValue = currentValue.subtract(entryAmount);
                    selling.add(sellValue);
                    numberOfAsserts = calculations.calculateBuyAsserts(numberOfAsserts, currentValue, entryAmount,buyPercent);
                    logger.info("Current Value: {}, Sell Value: {}, Total Asserts : {}", currentValue, sellValue, numberOfAsserts);
                } else if (percentageDiff.negate().compareTo(buyPercent) > 0) {
                    BigDecimal buyValue = entryAmount.subtract(currentValue);
                    buying.add(buyValue);
                    numberOfAsserts = calculations.calculateBuyAsserts(numberOfAsserts, currentValue, entryAmount,buyPercent);
                    logger.info("Current Value: {}, Buy Value: {}, Total Asserts : {}", currentValue, buyValue, numberOfAsserts);
                }
            }
            BigDecimal sellSum = selling.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal buySum = buying.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

            logger.info("Entry Amount : {} ", entryAmount);
            logger.info("Entry Value : {}, with buy percent : {}, and sell percent: {}", entryValue , buyPercent , sellPercent);
            logger.info("Total Sell Amount : {} ", sellSum);
            logger.info("Total Buy Amount : {} ", buySum);

        } catch (IOException e){
            logger.error("Error reading excel file : {} " ,e.getMessage());
        } catch (Exception e){
            logger.error("An unexpected error occurred: {} ", e.getMessage());
            e.printStackTrace();
        }
        logger.info("testStrategy :: end ..");

    }
}
