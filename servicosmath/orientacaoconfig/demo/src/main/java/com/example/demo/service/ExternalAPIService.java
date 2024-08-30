package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPIService {
    
    private final String url = "http://gateway.marvel.com/v1/public/characters?ts=1725024074&apikey=42df6928721067ac6140db26bab5c8be&hash=919f5a4fc8852aeb8c71812705f1f0e0";

    @Autowired
    private RestTemplate restTemplate;

    //GET retorna uma lista
    public String getAllData() {
        return restTemplate.getForObject(this.url, String.class);
    }
}
