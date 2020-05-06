package com.spring_disc.disc.disc.dao;

import com.spring_disc.disc.disc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserDaoMongoImpl {

    @Autowired
    private UserDao userDao;

    public Collection<User> getUser() {
        return userDao.findAll();
    }


    public User addUser(User user) {
        return userDao.insert(user);
    }
}
