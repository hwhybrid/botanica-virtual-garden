package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.PlantDto;

import java.util.List;

public interface PlantService {
    PlantDto createPlant(PlantDto plantDto);
    PlantDto getPlantById(Long plantId);
    PlantDto updatePlant(Long plantId, PlantDto plantDto);
    void deletePlant(Long plantId);
    List<PlantDto> getAllPlants();

    boolean isDatabaseSeeded();

    void deleteAllPlants();

    void loadPlantDataFromJson();

    List<PlantDto> getPlantOptionsForCarousel();
}
