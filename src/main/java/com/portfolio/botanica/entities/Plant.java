package com.portfolio.botanica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "plants")
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_id")
    private Long plantId;

    @Column(nullable = false)
    private String plantName;

    @Column(nullable = false)
    private String scientificName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String plantDescription;

    @Column(nullable = false)
    private boolean edible;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private List<PlantedPlant> plantedPlants;
}
