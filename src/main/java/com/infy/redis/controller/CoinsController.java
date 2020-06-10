package com.infy.redis.controller;


import com.infy.redis.dal.Coins;
import com.infy.redis.service.CoinsService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoinsController {


    @Autowired
    CoinsService coinsService;


    @RequestMapping(value = "/addCoins", method = RequestMethod.POST)
    public ResponseEntity<String> addCoins(@RequestBody Coins coins) {

        ModelMapper modelMapper = new ModelMapper();
        Coins coin = modelMapper.map(coins, Coins.class);


        Boolean result = coinsService.saveCoins(coin);
        if (result) {
            return ResponseEntity.ok("Coins are saved!!!");
        } else {
            return ResponseEntity.ok("An error occured!!!");
        }

    }


    @RequestMapping(value = "/findCoins", method = RequestMethod.POST)
    public ResponseEntity<Coins> findUser(@RequestBody Coins coins) {

        ModelMapper modelMapper = new ModelMapper();
        Coins user = modelMapper.map(coins, Coins.class);

        Coins result = coinsService.findByKey(user.getKey());

        return ResponseEntity.ok(result);


    }
}

