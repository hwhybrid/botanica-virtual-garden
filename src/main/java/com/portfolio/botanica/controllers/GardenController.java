package com.portfolio.botanica.controllers;

import com.portfolio.botanica.dtos.GardenDto;
import com.portfolio.botanica.entities.Garden;
import com.portfolio.botanica.repositories.GardenRepository;
import com.portfolio.botanica.services.GardenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/gardens")
public class GardenController {

    private final GardenService gardenService;
    private final GardenRepository gardenRepository;

    @Autowired
    public GardenController(GardenService gardenService, GardenRepository gardenRepository) {
        this.gardenService = gardenService;
        this.gardenRepository = gardenRepository;
    }

    @PostMapping
    public ResponseEntity<GardenDto> createGarden(@RequestBody GardenDto gardenDto) {
        GardenDto createdGarden = gardenService.createGarden(gardenDto);
        return new ResponseEntity<>(createdGarden, HttpStatus.CREATED);
    }

    @GetMapping("/{gardenId}")
    public ResponseEntity<GardenDto> getGardenById(@PathVariable Long gardenId) {
        GardenDto garden = gardenService.getGardenById(gardenId);
        if (garden != null) {
            return new ResponseEntity<>(garden, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{gardenId}")
    public ResponseEntity<GardenDto> updateGarden(@PathVariable Long gardenId, @RequestBody GardenDto gardenDto) {
        GardenDto updatedGarden = gardenService.updateGarden(gardenId, gardenDto);
        if (updatedGarden != null) {
            return new ResponseEntity<>(updatedGarden, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{gardenId}")
    public ResponseEntity<Void> deleteGarden(@PathVariable Long gardenId) {
        gardenService.deleteGarden(gardenId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<GardenDto>> getAllGardens() {
        List<GardenDto> gardens = gardenService.getAllGardens();
        return new ResponseEntity<>(gardens, HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<GardenDto>> getGardensByUser(@PathVariable String username) {
        List<Garden> gardens = gardenRepository.findByUserUsername(username);
        List<GardenDto> gardenDtos = new ArrayList<>();

        for (Garden garden : gardens) {
            GardenDto gardenDto = new GardenDto();
            BeanUtils.copyProperties(garden, gardenDto);
            gardenDtos.add(gardenDto);
        }

        return new ResponseEntity<>(gardenDtos, HttpStatus.OK);
    }

    @GetMapping("/user/{username}/count")
    public ResponseEntity<Long> countGardensByUser(@PathVariable String username) {
        long count = gardenRepository.countByUserUsername(username);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


}
