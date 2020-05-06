package com.spring_disc.disc.disc.dao;

import com.spring_disc.disc.disc.model.Movie;
import org.apache.el.stream.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface MovieDao extends MongoRepository<Movie,String> {


}
