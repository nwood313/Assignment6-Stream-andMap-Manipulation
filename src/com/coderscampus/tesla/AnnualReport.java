package com.coderscampus.tesla;

import java.time.YearMonth;

public class AnnualReport {
    YearMonth date;
    Integer sales;

    public AnnualReport(YearMonth date, Integer sales) {
        this.date = date;
        this.sales = sales;
    }

    public YearMonth getDate() {
        return date;
    }

    public Integer getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return "AnnualReport{" +
                "date=" + date +
                ", sales=" + sales +
                '}';
    }
}
