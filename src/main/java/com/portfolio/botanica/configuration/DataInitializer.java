package com.portfolio.botanica.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.portfolio.botanica.services.PlantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PlantService plantService;
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    public DataInitializer(PlantService plantService) {
        this.plantService = plantService;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("DataInitializer is running...");

//        // Delete all existing plant entries
//        plantService.deleteAllPlants();
        {
            // Check if the database is empty
            if (!plantService.isDatabaseSeeded()) {
                // If the database is empty, load plant data from JSON file
                plantService.loadPlantDataFromJson();
                logger.info("Plant data loaded from JSON.");

            }
        }
    }
}
