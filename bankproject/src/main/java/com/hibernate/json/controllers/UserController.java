package com.hibernate.json.controllers;

import com.hibernate.entity.User;
import com.hibernate.entity.UserData;
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

    @RequestMapping("/login")
    public ResponseEntity<Map<String, User>> login(@RequestParam(value="firstname") String firstName, @RequestParam(value="lastname") String lastName, @RequestParam(value="passnum") int passNum) {
        UserService us = new UserService();
        User user = us.login(firstName, lastName, passNum);
        Map<String, User> map = new HashMap<>();
        if(user != null) {
            map.put("user", user);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
    }

//    @RequestMapping("/showuserdata")
//    public ResponseEntity<Map<String, User>> showUserData(@RequestParam(value = "firstname") String firstName, @RequestParam(value="lastname") String lastName) {
//
////WIP
//
//        return new ResponseEntity<>();
//    }

    @RequestMapping(value = "/showData", method = RequestMethod.POST)
    public @ResponseBody User showData(@RequestBody User user) {
        int userId = userService.getUserIdByPassNum(user.getPassNum());
//        userService.getUserInfo(userId);

        return userService.getUserInfo(userId);
    }
}
