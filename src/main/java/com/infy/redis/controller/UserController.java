package com.infy.redis.controller;


import com.infy.redis.dal.User;
import com.infy.redis.service.AuthorizationService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    AuthorizationService authorizationService;


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<String> addUser(@RequestBody User User) {

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(User, User.class);


        Boolean result = authorizationService.saveUser(user);
        if (result) {
            return ResponseEntity.ok("A new user is saved!!!");
        } else {
            return ResponseEntity.ok("An error occured!!!");
        }

    }


    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public ResponseEntity<User> findUser(@RequestBody User User) {

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(User, User.class);

        User result = authorizationService.findByName(user.getName());

        return ResponseEntity.ok(result);


    }
}

