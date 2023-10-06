package com.portfolio.botanica.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantedPlantDto {
    private Long plantedPlantId;
    private PlantDto plant; // Reference to the plant
}
