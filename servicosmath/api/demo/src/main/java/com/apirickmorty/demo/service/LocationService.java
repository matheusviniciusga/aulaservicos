package com.apirickmorty.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apirickmorty.demo.exception.LocationNotFoundException;
import com.apirickmorty.demo.model.Location;
import com.apirickmorty.demo.repository.LocationRepository;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository lr;

    @Autowired
    private RestTemplate restTemplate;

    public Location addLocation(Location l) {
        return lr.save(l);
    }

    public void deleteLocation(Location l) {
        lr.delete(l);
    }

    public List<Location> searchAll() {
        return lr.findAll();
    }

    public Location searchById(Long id) throws LocationNotFoundException {
        Optional<Location> opL = lr.findById(id);

        if(opL.isEmpty()) {
            throw new LocationNotFoundException("Localidade não encontrada.");
        }

        return opL.get();
    }

    public Location searchByType(String type) {
        return lr.findByType(type);
    }

    public Location updateLocation(Long id, Location newLocation) throws LocationNotFoundException {
        Optional<Location> opL = lr.findById(id);

        if(opL.isEmpty()) {
            throw new LocationNotFoundException("Localidade do id (" + id + ") não encontrada.");
        }

        Location l = opL.get();
        l.setName(newLocation.getName());
        l.setType(newLocation.getType());
        l.setDimension(newLocation.getDimension());

        return lr.save(l);
    }

    //Requisição na API rickmorty para o BD
    public Location fetchAndSaveLocation(Long id) throws LocationNotFoundException {
        String url = "https://rickandmortyapi.com/api/location" + id;

        ResponseEntity<Location> resp = restTemplate.getForEntity(url, Location.class);

        if(resp.getStatusCode().is2xxSuccessful() && resp.getBody() != null) {
            Location l = resp.getBody();
            return lr.save(l);
        } else {
            throw new LocationNotFoundException("Busca na API da localidade (" + id + ") falhou.");
        }
    }
}
