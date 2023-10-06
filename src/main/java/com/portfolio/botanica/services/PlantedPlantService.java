package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.PlantedPlantDto;

import java.util.List;

public interface PlantedPlantService {
    PlantedPlantDto createPlantedPlant(PlantedPlantDto plantedPlantDto);
    PlantedPlantDto getPlantedPlantById(Long plantedPlantId);
    PlantedPlantDto updatePlantedPlant(Long plantedPlantId, PlantedPlantDto plantedPlantDto);
    void deletePlantedPlant(Long plantedPlantId);
    List<PlantedPlantDto> getAllPlantedPlants();
    List<PlantedPlantDto> getPlantedPlantsByUser(String username);
}
