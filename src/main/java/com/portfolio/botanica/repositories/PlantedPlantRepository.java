package com.portfolio.botanica.repositories;

import com.portfolio.botanica.entities.PlantedPlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantedPlantRepository extends JpaRepository<PlantedPlant, Long> {

    List<PlantedPlant> findByGardenUserUsername(String username);

//    List<PlantedPlant> findByGarden_GardenId(Long gardenId);


}
