package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.GardenDto;

import java.util.List;

public interface GardenService {
    GardenDto createGarden(GardenDto gardenDto);
    GardenDto getGardenById(Long gardenId);
    GardenDto updateGarden(Long gardenId, GardenDto gardenDto);
    void deleteGarden(Long gardenId);
    List<GardenDto> getAllGardens();
//    List<GardenDto> getGardensByUser(String username);
}
