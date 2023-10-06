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

    @ManyToOne
    @JoinColumn(name = "garden_id")
    private Garden garden;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;
}

