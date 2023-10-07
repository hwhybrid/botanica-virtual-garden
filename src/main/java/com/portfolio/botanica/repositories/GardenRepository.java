package com.portfolio.botanica.repositories;

import com.portfolio.botanica.entities.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Long> {

    List<Garden> findByUserUsername(String username);
    long countByUserUsername(String username);

}
