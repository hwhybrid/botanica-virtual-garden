package com.portfolio.botanica.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.botanica.dtos.PlantDto;
import com.portfolio.botanica.entities.Plant;
import com.portfolio.botanica.repositories.PlantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public PlantDto createPlant(PlantDto plantDto) {
        Plant plant = new Plant();
        BeanUtils.copyProperties(plantDto, plant);
        plantRepository.save(plant);
        return plantDto;
    }

    @Override
    public PlantDto getPlantById(Long plantId) {
        Optional<Plant> optionalPlant = plantRepository.findById(plantId);
        if (optionalPlant.isPresent()) {
            PlantDto plantDto = new PlantDto();
            BeanUtils.copyProperties(optionalPlant.get(), plantDto);
            return plantDto;
        }
        return null; // Handle the case where the plant with the given ID is not found
    }


    @Override
    public PlantDto updatePlant(Long plantId, PlantDto plantDto) {
        Plant plant = plantRepository.findById(plantId).orElse(null);
        if (plant != null) {
            BeanUtils.copyProperties(plantDto, plant);
            plantRepository.save(plant);
        }
        return plantDto;
    }

    @Override
    public void deletePlant(Long plantId) {
        plantRepository.deleteById(plantId);
    }

    @Override
    public List<PlantDto> getAllPlants() {
        List<PlantDto> plantDtos = new ArrayList<>();
        List<Plant> plants = plantRepository.findAll();
        for (Plant plant : plants) {
            PlantDto plantDto = new PlantDto();
            BeanUtils.copyProperties(plant, plantDto);
            plantDtos.add(plantDto);
        }
        return plantDtos;
    }

    @Override
    public boolean isDatabaseSeeded() {
        // Checks if there are any existing records in the plant table
        return plantRepository.count() > 0;
    }

    @Override
    public void deleteAllPlants() {
        plantRepository.deleteAll();
    }

    @Transactional
    public void loadPlantDataFromJson() {
        try {
            // Load the JSON file from the classpath
            Resource resource = new ClassPathResource("data/plants.json");
            InputStream inputStream = resource.getInputStream();

            // Parse the JSON data into an array of Plant objects
            ObjectMapper objectMapper = new ObjectMapper();
            Plant[] plants = objectMapper.readValue(inputStream, Plant[].class);

            // Save the parsed data into the database using your repository
            plantRepository.saveAll(Arrays.asList(plants));
        } catch (IOException e) {
            // Handle exceptions if the file is not found or cannot be loaded.
            e.printStackTrace();
        }
    }

    @Override
    public List<PlantDto> getPlantOptionsForCarousel() {
        List<Plant> plants = plantRepository.findAll();
        List<PlantDto> plantOptions = new ArrayList<>();
        for (Plant plant : plants) {
            PlantDto plantDto = new PlantDto();
            BeanUtils.copyProperties(plant, plantDto);
            // You may want to customize the data you copy to the DTO
            // based on what you want to show in the carousel.
            plantOptions.add(plantDto);
        }
        return plantOptions;
    }
}
