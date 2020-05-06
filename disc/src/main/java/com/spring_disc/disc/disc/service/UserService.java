package com.spring_disc.disc.disc.service;

import com.spring_disc.disc.disc.dao.UserDao;
import com.spring_disc.disc.disc.dao.UserDaoMongoImpl;
import com.spring_disc.disc.disc.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private final UserDaoMongoImpl userDaoMongo;

    public UserService(UserDaoMongoImpl userDaoMongo) {
        this.userDaoMongo = userDaoMongo;
    }

//    public int addUser(User user){
//        return userDao.insertUser(user);
//    }

    public Collection<User> getUser(){
        return userDaoMongo.getUser();
    }

    public User addUser(User user) {
        return userDaoMongo.addUser(user);
    }
}
