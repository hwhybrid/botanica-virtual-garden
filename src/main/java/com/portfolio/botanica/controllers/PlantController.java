package com.portfolio.botanica.controllers;

import com.portfolio.botanica.dtos.PlantDto;
import com.portfolio.botanica.entities.Plant;
import com.portfolio.botanica.repositories.PlantRepository;
import com.portfolio.botanica.services.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantService plantService;
    private final PlantRepository plantRepository;

    @Autowired
    public PlantController(PlantService plantService, PlantRepository plantRepository) {
        this.plantService = plantService;
        this.plantRepository = plantRepository;
    }

    @PostMapping
    public ResponseEntity<PlantDto> createPlant(@RequestBody PlantDto plantDto) {
        PlantDto createdPlant = plantService.createPlant(plantDto);
        return new ResponseEntity<>(createdPlant, HttpStatus.CREATED);
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<PlantDto> getPlantById(@PathVariable Long plantId) {
        PlantDto plant = plantService.getPlantById(plantId);
        if (plant != null) {
            return new ResponseEntity<>(plant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{plantId}")
    public ResponseEntity<PlantDto> updatePlant(@PathVariable Long plantId, @RequestBody PlantDto plantDto) {
        PlantDto updatedPlant = plantService.updatePlant(plantId, plantDto);
        if (updatedPlant != null) {
            return new ResponseEntity<>(updatedPlant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{plantId}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long plantId) {
        plantService.deletePlant(plantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<PlantDto>> getAllPlants() {
        List<PlantDto> plants = plantService.getAllPlants();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @GetMapping("/seeded")
    public ResponseEntity<Boolean> isDatabaseSeeded() {
        boolean seeded = plantService.isDatabaseSeeded();
        return new ResponseEntity<>(seeded, HttpStatus.OK);
    }

    @PostMapping("/loadData")
    public ResponseEntity<Void> loadPlantDataFromJson() {
        plantService.loadPlantDataFromJson();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllPlants() {
        plantService.deleteAllPlants();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/carouselOptions")
    public ResponseEntity<List<PlantDto>> getPlantOptionsForCarousel() {
        List<PlantDto> plantOptions = plantService.getPlantOptionsForCarousel();
        return new ResponseEntity<>(plantOptions, HttpStatus.OK);
    }


    @GetMapping("/name/{plantName}")
    public ResponseEntity<List<PlantDto>> getPlantsByPlantName(@PathVariable String plantName) {
        List<Plant> plants = plantRepository.findByPlantNameContaining(plantName);
        List<PlantDto> plantDtos = new ArrayList<>();
        for (Plant plant : plants) {
            PlantDto plantDto = new PlantDto();
            BeanUtils.copyProperties(plant, plantDto);
            plantDtos.add(plantDto);
        }
        return new ResponseEntity<>(plantDtos, HttpStatus.OK);
    }

    @GetMapping("/scientific/{scientificName}")
    public ResponseEntity<List<PlantDto>> getPlantsByScientificName(@PathVariable String scientificName) {
        List<Plant> plants = plantRepository.findByScientificNameContaining(scientificName);
        List<PlantDto> plantDtos = new ArrayList<>();
        for (Plant plant : plants) {
            PlantDto plantDto = new PlantDto();
            BeanUtils.copyProperties(plant, plantDto);
            plantDtos.add(plantDto);
        }
        return new ResponseEntity<>(plantDtos, HttpStatus.OK);
    }

    @GetMapping("/edible")
    public ResponseEntity<List<PlantDto>> getEdiblePlants() {
        List<Plant> plants = plantRepository.findByEdibleTrue();
        List<PlantDto> plantDtos = new ArrayList<>();
        for (Plant plant : plants) {
            PlantDto plantDto = new PlantDto();
            BeanUtils.copyProperties(plant, plantDto);
            plantDtos.add(plantDto);
        }
        return new ResponseEntity<>(plantDtos, HttpStatus.OK);
    }

    @GetMapping("/non-edible")
    public ResponseEntity<List<PlantDto>> getNonEdiblePlants() {
        List<Plant> plants = plantRepository.findByEdibleFalse();
        List<PlantDto> plantDtos = new ArrayList<>();
        for (Plant plant : plants) {
            PlantDto plantDto = new PlantDto();
            BeanUtils.copyProperties(plant, plantDto);
            plantDtos.add(plantDto);
        }
        return new ResponseEntity<>(plantDtos, HttpStatus.OK);
    }
}
