package com.nav.algo.dto;

import java.math.BigDecimal;

/**
 * @author Naveen Allaparthi
 */
public class UpDownLog {
    private BigDecimal currentTotalAssertValue;
    private BigDecimal currentAssertValue;
    private BigDecimal currentNumberOfAsserts;
    private BigDecimal percentageOfChange;
    private BigDecimal sellPercentage;
    private BigDecimal bugPercentage;
    private BigDecimal entryAmount;
    private BigDecimal sellValue;
    private BigDecimal buyValue;
    private BigDecimal numberOfAssertToSell;
    private BigDecimal numberOfAssertToBuy;

    public UpDownLog(BigDecimal entryAmount, BigDecimal currentTotalAssertValue, BigDecimal currentAssertValue, BigDecimal currentNumberOfAsserts, BigDecimal percentageOfChange, BigDecimal sellPercentage, BigDecimal bugPercentage, BigDecimal sellValue, BigDecimal buyValue) {
        this.entryAmount = entryAmount;
        this.currentTotalAssertValue = currentTotalAssertValue;
        this.currentAssertValue = currentAssertValue;
        this.currentNumberOfAsserts = currentNumberOfAsserts;
        this.percentageOfChange = percentageOfChange;
        this.sellPercentage = sellPercentage;
        this.bugPercentage = bugPercentage;
        this.sellValue = sellValue;
        this.buyValue = buyValue;
    }

    @Override
    public String toString() {
        return "LogRow{" +
                "CNOA="+currentNumberOfAsserts +
                ", CAV=" + currentAssertValue +
                ", CTAV="+currentTotalAssertValue +
                ", EA="+entryAmount +
                ", POC=" + percentageOfChange +
                ", SV=" + sellValue +
                ", BV=" + buyValue +
                ", NOATS=" + numberOfAssertToSell +
                ", NOATB=" + numberOfAssertToBuy +
                '}';
    }

    public BigDecimal getNumberOfAssertToBuy() {
        return numberOfAssertToBuy;
    }

    public void setNumberOfAssertToBuy(BigDecimal numberOfAssertToBuy) {
        this.numberOfAssertToBuy = numberOfAssertToBuy;
    }

    public BigDecimal getNumberOfAssertToSell() {
        return numberOfAssertToSell;
    }

    public void setNumberOfAssertToSell(BigDecimal numberOfAssertToSell) {
        this.numberOfAssertToSell = numberOfAssertToSell;
    }

    public BigDecimal getCurrentTotalAssertValue() {
        return currentTotalAssertValue;
    }

    public void setCurrentTotalAssertValue(BigDecimal currentTotalAssertValue) {
        this.currentTotalAssertValue = currentTotalAssertValue;
    }

    public BigDecimal getCurrentAssertValue() {
        return currentAssertValue;
    }

    public void setCurrentAssertValue(BigDecimal currentAssertValue) {
        this.currentAssertValue = currentAssertValue;
    }

    public BigDecimal getCurrentNumberOfAsserts() {
        return currentNumberOfAsserts;
    }

    public void setCurrentNumberOfAsserts(BigDecimal currentNumberOfAsserts) {
        this.currentNumberOfAsserts = currentNumberOfAsserts;
    }

    public BigDecimal getPercentageOfChange() {
        return percentageOfChange;
    }

    public void setPercentageOfChange(BigDecimal percentageOfChange) {
        this.percentageOfChange = percentageOfChange;
    }

    public BigDecimal getSellPercentage() {
        return sellPercentage;
    }

    public void setSellPercentage(BigDecimal sellPercentage) {
        this.sellPercentage = sellPercentage;
    }

    public BigDecimal getBugPercentage() {
        return bugPercentage;
    }

    public void setBugPercentage(BigDecimal bugPercentage) {
        this.bugPercentage = bugPercentage;
    }

    public BigDecimal getEntryAmount() {
        return entryAmount;
    }

    public void setEntryAmount(BigDecimal entryAmount) {
        this.entryAmount = entryAmount;
    }

    public BigDecimal getSellValue() {
        return sellValue;
    }

    public void setSellValue(BigDecimal sellValue) {
        this.sellValue = sellValue;
    }

    public BigDecimal getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(BigDecimal buyValue) {
        this.buyValue = buyValue;
    }
}
