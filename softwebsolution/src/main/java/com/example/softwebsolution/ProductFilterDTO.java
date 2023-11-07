package com.example.softwebsolution;

import com.sun.istack.internal.NotNull;
import org.springframework.lang.NonNull;

import java.util.Date;

public class ProductFilterDTO {

    private String name;

    private long startPrice;

    private Date startDate;

    private Date endDate;
    private long endPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(long startPrice) {
        this.startPrice = startPrice;
    }

    public long getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(long endPrice) {
        this.endPrice = endPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
