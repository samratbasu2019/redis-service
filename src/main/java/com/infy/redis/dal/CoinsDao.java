package com.infy.redis.dal;


public interface CoinsDao {

    public Boolean saveCoins(Coins coins) ;
    public Coins findByKey(String name) ;


}
