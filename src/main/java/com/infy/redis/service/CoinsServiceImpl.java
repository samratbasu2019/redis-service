package com.infy.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.redis.dal.Coins;
import com.infy.redis.dal.CoinsDao;

@Service
public class CoinsServiceImpl implements CoinsService {

    @Autowired
    CoinsDao userDao;


    public Boolean saveCoins(Coins user){
        return userDao.saveCoins(user) ;
    }

    @Override
    public Coins findByKey(String key) {

        return userDao.findByKey(key);
    }
}
