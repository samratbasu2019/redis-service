package com.infy.redis.dal;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {

    public List<User> findByName(String name) ;
    public List<User> findByNameAndSurname(String name , String surname) ;



}
