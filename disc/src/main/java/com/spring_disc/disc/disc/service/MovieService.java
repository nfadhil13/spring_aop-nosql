package com.spring_disc.disc.disc.service;


import com.spring_disc.disc.disc.dao.MovieDaoImpl;
import com.spring_disc.disc.disc.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieDaoImpl movieDaoImpl;


    public Movie addMovie(Movie movie) {
        return movieDaoImpl.addMovie(movie);
    }


    public Collection<Movie> getMovie() {
        return movieDaoImpl.getMovie();
    }

    public Movie updateMovie(Movie movie) {
        return movieDaoImpl.updateMovie(movie);
    }


    public Optional<Movie> getMovieById(String id) {
        return movieDaoImpl.getMovieById(id);
    }

    public void deleteById(String id) {
        movieDaoImpl.deleteById(id);
    }

    public Optional<Movie> findById(String id) {
        return movieDaoImpl.findById(id);
    }
}
