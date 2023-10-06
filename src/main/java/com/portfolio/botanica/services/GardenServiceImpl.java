package com.portfolio.botanica.services;

import com.portfolio.botanica.dtos.GardenDto;
import com.portfolio.botanica.entities.Garden;
import com.portfolio.botanica.repositories.GardenRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GardenServiceImpl implements GardenService {

    private final GardenRepository gardenRepository;

    @Autowired
    public GardenServiceImpl(GardenRepository gardenRepository) {
        this.gardenRepository = gardenRepository;
    }

    @Override
    public GardenDto createGarden(GardenDto gardenDto) {
        Garden garden = new Garden();
        BeanUtils.copyProperties(gardenDto, garden);
        gardenRepository.save(garden);
        return gardenDto;
    }

    @Override
    public GardenDto getGardenById(Long gardenId) {
        Optional<Garden> gardenOptional = gardenRepository.findById(gardenId);
        if (gardenOptional.isPresent()) {
            GardenDto gardenDto = new GardenDto();
            BeanUtils.copyProperties(gardenOptional.get(), gardenDto);
            return gardenDto;
        } else {
            // Handle the case where the garden is not found, e.g., by returning null or throwing an exception
            return null;
        }
    }


    @Override
    public GardenDto updateGarden(Long gardenId, GardenDto gardenDto) {
        Garden garden = gardenRepository.findById(gardenId).orElse(null);
        if (garden != null) {
            BeanUtils.copyProperties(gardenDto, garden);
            gardenRepository.save(garden);
        }
        return gardenDto;
    }

    @Override
    public void deleteGarden(Long gardenId) {
        gardenRepository.deleteById(gardenId);
    }

    @Override
    public List<GardenDto> getAllGardens() {
        List<GardenDto> gardenDtos = new ArrayList<>();
        List<Garden> gardens = gardenRepository.findAll();
        for (Garden garden : gardens) {
            GardenDto gardenDto = new GardenDto();
            BeanUtils.copyProperties(garden, gardenDto);
            gardenDtos.add(gardenDto);
        }
        return gardenDtos;
    }

}
