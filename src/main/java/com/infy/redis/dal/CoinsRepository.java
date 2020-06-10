package com.infy.redis.dal;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinsRepository extends CrudRepository<Coins, Long>  {

    public List<Coins> findByKey(String key) ;


}
