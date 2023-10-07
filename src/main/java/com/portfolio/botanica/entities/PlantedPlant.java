package com.portfolio.botanica.entities;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "planted_plants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlantedPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantedPlantId;
   @Transient
    private String plantName;

    @ManyToOne
    @JoinColumn(name = "garden_id")
    private Garden garden;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    // A getter method to fetch the plantName from the associated Garden entity
    public String getPlantName() {
        if (garden != null && plant != null) {
            // Assuming that the Garden entity has a method to fetch the plant name based on plantId
            return garden.getPlantNameByPlantId(plant.getPlantId());
        }
        return null;
    }
}

