package com.portfolio.botanica.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlantedPlantDto {
    private Long plantedPlantId;
    private Long gardenId;
    private PlantDto plant; // Reference to the plant
}
