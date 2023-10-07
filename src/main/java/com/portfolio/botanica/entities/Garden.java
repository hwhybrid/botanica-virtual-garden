package com.portfolio.botanica.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "gardens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gardenId;

    @Column
    private String gardenName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "garden", cascade = CascadeType.ALL)
    private List<PlantedPlant> plantedPlants;


    public String getPlantNameByPlantId(Long plantId) {
        if (plantedPlants != null) {
            for (PlantedPlant plantedPlant : plantedPlants) {
                if (plantedPlant != null && plantedPlant.getPlant() != null && plantedPlant.getPlant().getPlantId().equals(plantId)) {
                    return plantedPlant.getPlant().getPlantName();
                }
            }
        }

        // If the plantId is not found in the current garden's plantedPlants, you can fetch it from the Plant entity
        if (plantedPlants != null) {
            Optional<PlantedPlant> plantedPlantWithId = plantedPlants.stream()
                    .filter(plantedPlant -> plantedPlant != null && plantedPlant.getPlant() != null && plantedPlant.getPlant().getPlantId().equals(plantId))
                    .findFirst();

            if (plantedPlantWithId.isPresent()) {
                return plantedPlantWithId.get().getPlant().getPlantName();
            }
        }

        return null; // Return null if no matching plantId is found
    }

}