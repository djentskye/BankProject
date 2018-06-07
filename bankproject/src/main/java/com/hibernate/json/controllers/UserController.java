package com.hibernate.json.controllers;

import com.hibernate.entity.User;
import com.hibernate.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @RequestMapping("/logins")
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
}
