package com.infy.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.redis.dal.User;
import com.infy.redis.dal.UserDao;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    UserDao userDao;


    public Boolean saveUser(User user){
        return userDao.saveUser(user) ;
    }

    @Override
    public User findByName(String name) {

        return userDao.findByName(name);
    }
}
