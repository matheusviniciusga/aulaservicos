package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
