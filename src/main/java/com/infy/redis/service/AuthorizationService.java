package com.infy.redis.service;

import com.infy.redis.dal.User;

public interface AuthorizationService {


    public Boolean saveUser(User user);

    public User findByName(String name);


}
