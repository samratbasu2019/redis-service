package com.infy.redis.controller;


import com.infy.redis.dal.Coins;
import com.infy.redis.service.CoinsService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CoinsController {
	protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    CoinsService coinsService;


    @RequestMapping(value = "/addCoins", method = RequestMethod.POST)
    public ResponseEntity<String> addCoins(@RequestBody Coins coins) {

        ModelMapper modelMapper = new ModelMapper();
        Coins coin = modelMapper.map(coins, Coins.class);

        logger.info("Coins are getting saved");
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
        Coins coin = modelMapper.map(coins, Coins.class);
        logger.info("Coins are getting fetched for this key : "+coin.getKey());
        Coins result = coinsService.findByKey(coin.getKey());

        return ResponseEntity.ok(result);


    }
}

