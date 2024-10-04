package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

import main.java.com.example.demo.model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user/")
public class UserController {
    
    @Autowired
    private UserService us;

    @PostMapping("path")
    public User postUser(@RequestBody User u) {
        return us.addUser(u);
    }
    
}
