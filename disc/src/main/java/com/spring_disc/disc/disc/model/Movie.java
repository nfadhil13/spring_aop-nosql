package com.spring_disc.disc.disc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(value = "Movies")
public class Movie {

    @Id
    private String id;
    private String title;
    private int releaseYear;
    private String rating;
    private String genre;
    private int stock;
    private List<DVD> dvdList;

    public Movie(){

    }

    public Movie(String id, String title, int releaseYear, String rating, String genre, int stock, List<DVD> dvdList) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.stock = stock;
        this.dvdList = dvdList;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<DVD> getDvdList() {
        return dvdList;
    }

    public void setDvdList(List<DVD> dvdList) {
        this.dvdList = dvdList;
    }
}
