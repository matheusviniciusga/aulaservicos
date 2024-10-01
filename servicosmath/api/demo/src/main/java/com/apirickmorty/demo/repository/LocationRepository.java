package com.apirickmorty.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirickmorty.demo.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
    public Location findByType(String type);
}
