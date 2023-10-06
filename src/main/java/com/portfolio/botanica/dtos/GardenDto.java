package com.portfolio.botanica.dtos;

import com.portfolio.botanica.entities.Garden;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GardenDto {
    private Long gardenId;
    private String gardenName;
    private Long userId;
    private List<PlantedPlantDto> plantedPlants;

}
