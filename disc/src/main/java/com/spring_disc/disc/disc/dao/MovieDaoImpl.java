package com.spring_disc.disc.disc.dao;

import com.spring_disc.disc.disc.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class MovieDaoImpl {

    @Autowired
    MovieDao movieDao;

    public Movie addMovie(Movie movie) {

        return movieDao.insert(movie);
    }


    public Collection<Movie> getMovie() {
        return movieDao.findAll();
    }

    public Movie updateMovie(Movie movie) {
        return movieDao.save(movie);
    }

    public Optional<Movie> getMovieById(String id) {
        return movieDao.findById(id);
    }

    public void deleteById(String id) {
        movieDao.deleteById(id);
    }

    public Optional<Movie> findById(String id) {
        return movieDao.findById(id);
    }
}
