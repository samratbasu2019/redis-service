package com.infy.redis.service;

import com.infy.redis.dal.Coins;

public interface CoinsService {


    public Boolean saveCoins(Coins user);

    public Coins findByKey(String key);


}
