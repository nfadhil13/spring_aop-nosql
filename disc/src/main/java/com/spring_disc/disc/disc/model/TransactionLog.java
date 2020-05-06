package com.spring_disc.disc.disc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document
public class TransactionLog {

    @Id
    private String code;
    private String movieCode;
    private String movieTitle;
    private String codeDVD;
    private LocalDate startDate;
    private int rentDays;
    private boolean available;
    private LocalDate endDate;
    private String renterEmail;
    private String renterAddress;
    private String renterName;

    public TransactionLog() {
    }

    public TransactionLog(String code, String movieCode, String movieTitle, String codeDVD, LocalDate startDate, int rentDays, boolean available, LocalDate endDate, String renterEmail, String renterAddress, String renterName) {
        this.code = code;
        this.movieCode = movieCode;
        this.movieTitle = movieTitle;
        this.codeDVD = codeDVD;
        this.startDate = startDate;
        this.rentDays = rentDays;
        this.available = available;
        this.endDate = endDate;
        this.renterEmail = renterEmail;
        this.renterAddress = renterAddress;
        this.renterName = renterName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
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

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(String movieCode) {
        this.movieCode = movieCode;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCodeDVD() {
        return codeDVD;
    }

    public void setCodeDVD(String codeDVD) {
        this.codeDVD = codeDVD;
    }


    public String getRenterEmail() {
        return renterEmail;
    }

    public void setRenterEmail(String renterEmail) {
        this.renterEmail = renterEmail;
    }

    public String getRenterAddress() {
        return renterAddress;
    }

    public void setRenterAddress(String renterAddress) {
        this.renterAddress = renterAddress;
    }
}
