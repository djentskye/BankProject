package com.hibernate.json.controllers;

import com.hibernate.entity.User;
import com.hibernate.security.JwtGenerateToken;
import com.hibernate.security.auth.JwtDecodeToken;
import com.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResponseEntity<String> register(@RequestParam(value="first_name") String firstName, @RequestParam(value="last_name") String lastName, @RequestParam(value="username") String username, @RequestParam(value="passnum") int passnum) {
        userService.newUser(firstName, lastName, username, passnum);
        User u = userService.login(username, passnum);
        Map<String, User> map = new HashMap<>();
        if(u != null) {
            map.put("user", u);
            String token = JwtGenerateToken.newUserToken(u);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity(map, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<String> login(@RequestParam(value="username") String username, @RequestParam(value="passnum") int passNum) {
        UserService us = new UserService();
        User user = us.login(username, passNum);
        Map<String, User> map = new HashMap<>();
        if(user != null) {
            map.put("user", user);
            String token = JwtGenerateToken.newUserToken(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity(map, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/showData", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<User> showData(@RequestHeader(value="Authorization") String token) {
        User a = JwtDecodeToken.decodeUserJwt(token);
        if (a.getUserName()!=null && a.getPassNum()!=0) {
            userService = new UserService(); //TODO: TO REMOVE
            int userId = userService.getUserIdByPassNum(a.getPassNum());
            if(userId!=-1) {
                User rUser = userService.getUserInfo(userId);
                return new ResponseEntity<User>(rUser, HttpStatus.OK);
            } else {
                System.out.println("ERROR 1");
                return new ResponseEntity<User>(a, HttpStatus.FORBIDDEN);
            }
        } else {
            System.out.println("ERROR 2");
            return new ResponseEntity<User>(a, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * The User parameter MUST include what will be changed AND the ID of the user.
     *
     * @param uData
     * @return
     */
    @RequestMapping(path = "/modifyUserData", method = RequestMethod.PATCH, consumes = "application/json")
    public @ResponseBody ResponseEntity<User> modifyUserData(@RequestBody User uData) {
//        User userToModify = userService.getUserInfo(uData.getId());
        return new ResponseEntity<User>(userService.modifyUser(uData), HttpStatus.OK);
    }
}
