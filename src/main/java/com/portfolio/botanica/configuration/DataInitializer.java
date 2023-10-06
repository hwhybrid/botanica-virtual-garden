package com.portfolio.botanica.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.portfolio.botanica.services.PlantService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PlantService plantService;

    public DataInitializer(PlantService plantService) {
        this.plantService = plantService;
    }

    @Override
    public void run(String... args) throws Exception {
//        // Delete all existing plant entries
//        plantService.deleteAllPlants();
        {
            // Check if the database is empty
            if (!plantService.isDatabaseSeeded()) {
                // If the database is empty, load plant data from JSON file
                plantService.loadPlantDataFromJson();
            }
        }
    }
}
