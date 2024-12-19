package com.nav.algo.strategy;

import com.nav.algo.dto.HistoricalData;
import com.nav.algo.dto.UpDownLog;
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
        List<UpDownLog> logs = new ArrayList<>();
        try{
            List<HistoricalData> hData = excelUtils.getData(excelFilePath);
            //Sort the data order by date in case for back testing purpose
            //Collections.sort(hData);
            for (HistoricalData data : hData){
                BigDecimal currentAssertValue = BigDecimal.valueOf(data.getClose());
                BigDecimal currentValue = currentAssertValue.multiply(numberOfAsserts);
                BigDecimal percentageDiff = currentValue.subtract(entryAmount).divide(entryAmount, 4,  RoundingMode.HALF_UP).multiply(new BigDecimal(100));

                if(currentValue.compareTo(entryAmount) > 0 && percentageDiff.compareTo(sellPercent) > 0){
                    BigDecimal sellValue = currentValue.subtract(entryAmount);
                    selling.add(sellValue);
                    UpDownLog row = new UpDownLog(entryAmount, currentValue, currentAssertValue, numberOfAsserts, percentageDiff, sellPercent, buyPercent, sellValue, BigDecimal.ZERO);
                    numberOfAsserts = calculations.calculateNo0fAssertsToSell(numberOfAsserts, sellValue, currentAssertValue, row);
                    logs.add(row);
                } else if (percentageDiff.negate().compareTo(buyPercent) > 0) {
                    BigDecimal buyValue = entryAmount.subtract(currentValue);
                    buying.add(buyValue);
                    UpDownLog logRow = new UpDownLog(entryAmount, currentValue, currentAssertValue, numberOfAsserts, percentageDiff, sellPercent, buyPercent, BigDecimal.ZERO, buyValue);
                    numberOfAsserts = calculations.calculateNo0fAssertsToBuy(numberOfAsserts, buyValue, currentAssertValue, logRow);
                    logs.add(logRow);
                }
            }
            BigDecimal sellSum = selling.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal buySum = buying.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

            logger.info("================================== Transaction Details==========================================");
            for (UpDownLog log : logs){
                System.out.println(log);
            }
            logger.info("===================================== Final Stats===============================================");
            logger.info("Entry Amount : {} ", entryAmount);
            logger.info("Entry Value : {} ", entryValue);
            logger.info("Buy Percent : {},  Sell Percent: {}",  buyPercent , sellPercent);
            logger.info("Number of Sell Transactions Triggered : {} ", selling.size());
            logger.info("Number of Buy Transactions Triggered : {} ", buying.size());
            logger.info("Total Sell Amount : {} ", sellSum);
            logger.info("Total Buy Amount : {} ", buySum);
            logger.info("Total Profit / Loss : {} ", sellSum.subtract(buySum));
            logger.info("=================================== *************  * ==========================================");
        } catch (IOException e){
            logger.error("Error reading excel file : {} " ,e.getMessage());
        } catch (Exception e){
            logger.error("An unexpected error occurred: {} ", e.getMessage());
            e.printStackTrace();
        }
        logger.info("testStrategy :: end ..");

    }
}
