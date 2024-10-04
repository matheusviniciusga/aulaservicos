package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

import main.java.com.example.demo.model.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository ur;

    public User addUser(User u) {
        return ur.add(u);
    }
}
