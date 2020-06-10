package com.infy.redis.dal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class CoinsDaoImpl implements CoinsDao {

    @Autowired
    CoinsRepository userRepository;

    @Autowired
    RedisTemplate redisTemplate;

    private static final String KEY = "coins";

    public Boolean saveCoins(Coins coins) {
        try {
            Map userHash = new ObjectMapper().convertValue(coins, Map.class);
            redisTemplate.opsForHash().put(KEY, coins.getKey(), userHash);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Coins findByKey(String key) {

        Map userMap = (Map) redisTemplate.opsForHash().get(KEY, key);
        Coins user = new ObjectMapper().convertValue(userMap, Coins.class);
        return user;
    }

}
