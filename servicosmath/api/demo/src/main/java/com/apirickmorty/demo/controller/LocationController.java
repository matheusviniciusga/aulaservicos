package com.apirickmorty.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirickmorty.demo.exception.LocationNotFoundException;
import com.apirickmorty.demo.model.Location;
import com.apirickmorty.demo.service.LocationService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/location")
public class LocationController {
    
    @Autowired
    private LocationService ls;

    @PostMapping("/add")
    public Location postLocation(@RequestBody Location l) {
        return ls.addLocation(l);
    }

    @DeleteMapping("/delete")
    public void removeLocation(Location l) {
        ls.deleteLocation(l);
    }

    @GetMapping("/all")
    public List<Location> getAllLocation() {
        return ls.searchAll();
    }
    
    @GetMapping("/id/{id}")
    public Location getById(@RequestParam Long id) throws LocationNotFoundException {
        try{
            return ls.searchById(id);
        } catch(LocationNotFoundException le) {
            return null;
        }
    }
    
    @GetMapping("/type/{type}")
    public Location getByType(@RequestParam String type) {
        return ls.searchByType(type);
    }
    
    @PutMapping("path/{id}")
    public Location changeLocation(@PathVariable Long id, @RequestBody Location l) throws LocationNotFoundException {
        try {
            return ls.updateLocation(id, l);
        } catch(LocationNotFoundException le) {
            return null;
        }
    }

    //Endpoit da API rickmorty para o BD]
    @GetMapping("/fetch/{id}")
    public Location findAndSaveLocation(@PathVariable Long id) throws LocationNotFoundException {
        try {
            return ls.fetchAndSaveLocation(id);
        } catch(LocationNotFoundException le) {
            return null;
        }
    }
    
}
