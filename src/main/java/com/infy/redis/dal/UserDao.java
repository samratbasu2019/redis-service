package com.infy.redis.dal;


public interface UserDao {

    public Boolean saveUser(User user) ;
    public User findByName(String name) ;


}
