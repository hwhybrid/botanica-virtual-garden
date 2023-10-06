package com.portfolio.botanica.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GardenDto {
    private Long gardenId;
    private String gardenName;
    private List<PlantedPlantDto> plantedPlants;
}
