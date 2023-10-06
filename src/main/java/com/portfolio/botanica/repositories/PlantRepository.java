package com.portfolio.botanica.repositories;

import com.portfolio.botanica.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    // These are your custom queries.
    // Define them as needed for your project.

    List<Plant> findByPlantNameContaining(String plantName);

    List<Plant> findByScientificNameContaining(String scientificName);

    List<Plant> findByEdibleTrue();

    List<Plant> findByEdibleFalse();


}
