package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.PlantedPlantDto;
import com.portfolio.botanica.entities.PlantedPlant;
import com.portfolio.botanica.repositories.PlantedPlantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlantedPlantServiceImpl implements PlantedPlantService {

    private final PlantedPlantRepository plantedPlantRepository;

    @Autowired
    public PlantedPlantServiceImpl(PlantedPlantRepository plantedPlantRepository) {
        this.plantedPlantRepository = plantedPlantRepository;
    }

    @Override
    public PlantedPlantDto createPlantedPlant(PlantedPlantDto plantedPlantDto) {
        PlantedPlant plantedPlant = new PlantedPlant();
        BeanUtils.copyProperties(plantedPlantDto, plantedPlant);
        plantedPlantRepository.save(plantedPlant);
        return plantedPlantDto;
    }

    @Override
    public PlantedPlantDto getPlantedPlantById(Long plantedPlantId) {
        Optional<PlantedPlant> optionalPlantedPlant = plantedPlantRepository.findById(plantedPlantId);
        if (optionalPlantedPlant.isPresent()) {
            PlantedPlantDto plantedPlantDto = new PlantedPlantDto();
            BeanUtils.copyProperties(optionalPlantedPlant.get(), plantedPlantDto);
            return plantedPlantDto;
        }
        return null; // Handle the case where the PlantedPlant does not exist
    }

    @Override
    public PlantedPlantDto updatePlantedPlant(Long plantedPlantId, PlantedPlantDto plantedPlantDto) {
        Optional<PlantedPlant> optionalPlantedPlant = plantedPlantRepository.findById(plantedPlantId);
        if (optionalPlantedPlant.isPresent()) {
            PlantedPlant plantedPlant = optionalPlantedPlant.get();
            BeanUtils.copyProperties(plantedPlantDto, plantedPlant);
            plantedPlantRepository.save(plantedPlant);
            return plantedPlantDto;
        }
        return null; // Handle the case where the PlantedPlant does not exist
    }

    @Override
    public void deletePlantedPlant(Long plantedPlantId) {
        plantedPlantRepository.deleteById(plantedPlantId);
    }

    @Override
    public List<PlantedPlantDto> getAllPlantedPlants() {
        List<PlantedPlantDto> plantedPlantDtos = new ArrayList<>();
        List<PlantedPlant> plantedPlants = plantedPlantRepository.findAll();
        for (PlantedPlant plantedPlant : plantedPlants) {
            PlantedPlantDto plantedPlantDto = new PlantedPlantDto();
            BeanUtils.copyProperties(plantedPlant, plantedPlantDto);
            plantedPlantDtos.add(plantedPlantDto);
        }
        return plantedPlantDtos;
    }

    @Override
    public List<PlantedPlantDto> getPlantedPlantsByUser(String username) {
        List<PlantedPlantDto> plantedPlantDtos = new ArrayList<>();
        List<PlantedPlant> plantedPlants = plantedPlantRepository.findByGardenUserUsername(username);
        for (PlantedPlant plantedPlant : plantedPlants) {
            PlantedPlantDto plantedPlantDto = new PlantedPlantDto();
            BeanUtils.copyProperties(plantedPlant, plantedPlantDto);
            plantedPlantDtos.add(plantedPlantDto);
        }
        return plantedPlantDtos;
    }
}
