package com.portfolio.botanica.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
}