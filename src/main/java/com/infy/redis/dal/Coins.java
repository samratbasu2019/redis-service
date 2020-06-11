package com.infy.redis.dal;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Data
@RedisHash("Coins")
public class Coins implements Serializable{

    @Id
    private Long id;
    private String key;
    private Deals deals;
    private Default defaults;
    private Long dealStartDate;
    private Long dealEndDate;
}
