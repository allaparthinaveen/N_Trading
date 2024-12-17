package com.nav.algo.dto;

import java.util.Date;

public class HistoricalData  implements  Comparable<HistoricalData> {

    private Date date;
    private double open;
    private double high;
    private double low;
    private double close;
    private  double adjClose;

    @Override
    public  int compareTo(HistoricalData o){
        return getDate().compareTo(o.getDate());
    }

    @Override
    public String toString() {
        return "HistoricalData{" +
                "date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", adjClose=" + adjClose +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(double adjClose) {
        this.adjClose = adjClose;
    }

}
