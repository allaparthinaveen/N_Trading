package com.nav.algo.dto;

import java.math.BigDecimal;

public class AveragePossibility {

    private BigDecimal currentInvestment;
    private BigDecimal currentNumberOfAsserts;
    private BigDecimal currentAverageAssertValue;
    private BigDecimal currentAssertPrice;
    private BigDecimal currentChangePercentage;
    private BigDecimal currentProfitOrLoss;
    private BigDecimal currentAssertWorth;


    private BigDecimal updatedInvestment;
    private BigDecimal updatedNumberOfAsserts;
    private BigDecimal updatedAverageAssertValue;
    private BigDecimal updatedAssertPrice;
    private BigDecimal updatedChangePercentage;
    private BigDecimal updatedProfitOrLoss;
    private BigDecimal updatedAssertWorth;

    private BigDecimal newInvestment;
    private BigDecimal raisePercentage;
    private BigDecimal additionalAssertsToBeRaised;


    public BigDecimal getCurrentInvestment() {
        return currentInvestment;
    }
    public void setCurrentInvestment(BigDecimal currentInvestment) {
        this.currentInvestment = currentInvestment;
    }
    public BigDecimal getCurrentNumberOfAsserts() {
        return currentNumberOfAsserts;
    }
    public void setCurrentNumberOfAsserts(BigDecimal currentNumberOfAsserts) {
        this.currentNumberOfAsserts = currentNumberOfAsserts;
    }
    public BigDecimal getCurrentAverageAssertValue() {
        return currentAverageAssertValue;
    }
    public void setCurrentAverageAssertValue(BigDecimal currentAverageAssertValue) {
        this.currentAverageAssertValue = currentAverageAssertValue;
    }
    public BigDecimal getCurrentAssertPrice() {
        return currentAssertPrice;
    }
    public void setCurrentAssertPrice(BigDecimal currentAssertPrice) {
        this.currentAssertPrice = currentAssertPrice;
    }
    public BigDecimal getCurrentChangePercentage() {
        return currentChangePercentage;
    }
    public void setCurrentChangePercentage(BigDecimal currentChangePercentage) {
        this.currentChangePercentage = currentChangePercentage;
    }
    public BigDecimal getCurrentProfitOrLoss() {
        return currentProfitOrLoss;
    }
    public void setCurrentProfitOrLoss(BigDecimal currentProfitOrLoss) {
        this.currentProfitOrLoss = currentProfitOrLoss;
    }
    public BigDecimal getCurrentAssertWorth() {
        return currentAssertWorth;
    }
    public void setCurrentAssertWorth(BigDecimal currentAssertWorth) {
        this.currentAssertWorth = currentAssertWorth;
    }
    public BigDecimal getUpdatedInvestment() {
        return updatedInvestment;
    }
    public void setUpdatedInvestment(BigDecimal updatedInvestment) {
        this.updatedInvestment = updatedInvestment;
    }
    public BigDecimal getUpdatedNumberOfAsserts() {
        return updatedNumberOfAsserts;
    }
    public void setUpdatedNumberOfAsserts(BigDecimal updatedNumberOfAsserts) {
        this.updatedNumberOfAsserts = updatedNumberOfAsserts;
    }
    public BigDecimal getUpdatedAverageAssertValue() {
        return updatedAverageAssertValue;
    }
    public void setUpdatedAverageAssertValue(BigDecimal updatedAverageAssertValue) {
        this.updatedAverageAssertValue = updatedAverageAssertValue;
    }
    public BigDecimal getUpdatedAssertPrice() {
        return updatedAssertPrice;
    }
    public void setUpdatedAssertPrice(BigDecimal updatedAssertPrice) {
        this.updatedAssertPrice = updatedAssertPrice;
    }
    public BigDecimal getUpdatedChangePercentage() {
        return updatedChangePercentage;
    }
    public void setUpdatedChangePercentage(BigDecimal updatedChangePercentage) {
        this.updatedChangePercentage = updatedChangePercentage;
    }
    public BigDecimal getUpdatedProfitOrLoss() {
        return updatedProfitOrLoss;
    }
    public void setUpdatedProfitOrLoss(BigDecimal updatedProfitOrLoss) {
        this.updatedProfitOrLoss = updatedProfitOrLoss;
    }
    public BigDecimal getUpdatedAssertWorth() {
        return updatedAssertWorth;
    }
    public void setUpdatedAssertWorth(BigDecimal updatedAssertWorth) {
        this.updatedAssertWorth = updatedAssertWorth;
    }
    public BigDecimal getNewInvestment() {
        return newInvestment;
    }
    public void setNewInvestment(BigDecimal newInvestment) {
        this.newInvestment = newInvestment;
    }
    public BigDecimal getRaisePercentage() {
        return raisePercentage;
    }
    public void setRaisePercentage(BigDecimal raisePercentage) {
        this.raisePercentage = raisePercentage;
    }
    public BigDecimal getAdditionalAssertsToBeRaised() {
        return additionalAssertsToBeRaised;
    }
    public void setAdditionalAssertsToBeRaised(BigDecimal additionalAssertsToBeRaised) {
        this.additionalAssertsToBeRaised = additionalAssertsToBeRaised;
    }
    @Override
    public String toString() {
        return "AveragePossibility [\ncurrentInvestment=" + currentInvestment + ", \n currentNumberOfAsserts="
                + currentNumberOfAsserts + ", \n currentAverageAssertValue=" + currentAverageAssertValue
                + ", \n currentAssertPrice=" + currentAssertPrice + ", \n currentChangePercentage=" + currentChangePercentage
                + ", \n currentProfitOrLoss=" + currentProfitOrLoss + ", \n currentAssertWorth=" + currentAssertWorth
                + ", \n updatedInvestment=" + updatedInvestment + ", \n updatedNumberOfAsserts=" + updatedNumberOfAsserts
                + ", \n updatedAverageAssertValue=" + updatedAverageAssertValue + ", \n updatedAssertPrice="
                + updatedAssertPrice + ", \n updatedChangePercentage=" + updatedChangePercentage + ", \n updatedProfitOrLoss="
                + updatedProfitOrLoss + ", \n updatedAssertWorth=" + updatedAssertWorth + ",\n  newInvestment="
                + newInvestment + ", \n raisePercentage=" + raisePercentage + ", \n additionalAssertsToBeRaised="
                + additionalAssertsToBeRaised + "]";
    }



}