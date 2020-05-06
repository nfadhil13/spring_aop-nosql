package com.spring_disc.disc.disc.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;

public class DVD {

    private String code;
    private boolean available;
    private LocalDate startDate;
    private LocalDate endDate;

    public DVD() {
    }

    public DVD(String code, boolean available, LocalDate startDate, LocalDate endDate) {
        this.code = code;
        this.available = available;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
