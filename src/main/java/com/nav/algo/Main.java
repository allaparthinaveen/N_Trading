package com.nav.algo;

import com.nav.algo.strategy.UpAndDownStrategy;

import java.math.BigDecimal;
import com.algo.dto.CallLog;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello, Let's start execution..");
        BigDecimal entryAmount = new BigDecimal(1000);
        BigDecimal entryValue = new BigDecimal(100);
        BigDecimal buyPercent = new BigDecimal(10);
        BigDecimal sellPercent = new BigDecimal(10);
        BigDecimal noOfAsserts = new BigDecimal(10);

        CallLog log = new CallLog();
        UpAndDownStrategy upAndDownStrategy = new UpAndDownStrategy();
        upAndDownStrategy.testStrategy(entryAmount, entryValue, buyPercent, sellPercent, noOfAsserts, log);
        System.out.println("API FLOW:" + log.getCallHierarchy());
    }
}