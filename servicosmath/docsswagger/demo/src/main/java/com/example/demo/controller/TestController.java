package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.demo.dto.PersonDTO;

@RestController
@RequestMapping("hello-world")
public class TestController {
    
    @GetMapping("hello-world")
    public String helloEndpoint() {
        return "Hello World";
    }

    @GetMapping("test/name={name}&gae={age}")
    public String retriveInformation(@PathVariable String name, @PathVariable Short age) {
        return "Hello " + name + ", you are " + age + " years old";
    }

    @PostMapping("insert/")
    public PersonDTO insertPerson(@RequestBody PersonDTO person) {
        //servico que insere uma pessoa no banco de dados
        return person;
    }
}
