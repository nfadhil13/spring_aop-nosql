package com.spring_disc.disc.disc.dao;

import com.spring_disc.disc.disc.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User,String> {

}
