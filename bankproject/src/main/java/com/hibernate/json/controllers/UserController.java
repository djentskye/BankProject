package com.hibernate.json.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.hibernate.entity.User;
import com.hibernate.entity.UserData;
import com.hibernate.security.JwtGenerateToken;
import com.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> login(@RequestParam(value="firstname") String firstName, @RequestParam(value="lastname") String lastName, @RequestParam(value="passnum") int passNum) {
        UserService us = new UserService();
        User user = us.login(firstName, lastName, passNum);
        Map<String, User> map = new HashMap<>();
        if(user != null) {
            map.put("user", user);
//            String token = JwtGenerateToken.newToken(String.valueOf(map));
            String token = JwtGenerateToken.newUserToken(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity(map, HttpStatus.NO_CONTENT);
    }

    //BACKUP
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ResponseEntity<Map<String, User>> login(@RequestParam(value="firstname") String firstName, @RequestParam(value="lastname") String lastName, @RequestParam(value="passnum") int passNum) {
//        UserService us = new UserService();
//        User user = us.login(firstName, lastName, passNum);
//        Map<String, User> map = new HashMap<>();
//        if(user != null) {
//            map.put("user", user);
//            return new ResponseEntity<>(map, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
//    }

    @RequestMapping(value = "/showData", method = RequestMethod.POST)
    public @ResponseBody User showData(@RequestBody User user) {
        int userId = userService.getUserIdByPassNum(user.getPassNum());
        return userService.getUserInfo(userId);
    }

//    @RequestMapping(value = "/showData", method = RequestMethod.POST)
//    public @ResponseBody User showData(@RequestBody User user) {
//        int userId = userService.getUserIdByPassNum(user.getPassNum());
//        return userService.getUserInfo(userId);
//    }
}
