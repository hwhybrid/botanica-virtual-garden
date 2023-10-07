import React, { useState, useEffect } from 'react';
import { Container, Typography, Paper, Button, List, ListItem, Grid } from '@mui/material';
import axios from "axios";

const CreatedGardenView = () => {
    const [gardenData, setGardenData] = useState({
        gardenName: "",
        selectedPlants: [],
        plantedPlants: [], // Initialize with an empty array
    });

    // Use this useEffect to retrieve query parameters and initialize state
    useEffect(() => {
        // Parse the query parameters from the URL
        const params = new URLSearchParams(window.location.search);
        const gardenNameParam = params.get('gardenName');
        const selectedPlantsParam = params.get('selectedPlants');

        setGardenData((prevData) => {
            const updatedGardenData = { ...prevData };

            // Sets garden name and selected plants in state
            if (gardenNameParam) {
                updatedGardenData.gardenName = gardenNameParam;
            }
            if (selectedPlantsParam) {
                // Further process the selected plant IDs if needed
                // For example, convert them to an array
                const selectedPlantIds = selectedPlantsParam.split(',');

                // Update the state with selected plant IDs
                updatedGardenData.selectedPlants = selectedPlantIds;

                // Fetch details of selected plants from the backend
                fetchSelectedPlantDetails(selectedPlantIds);
            }

            // You can fetch additional garden data from the backend if necessary

            return updatedGardenData;
        });
    }, []);

    const fetchSelectedPlantDetails = (selectedPlantIds) => {
        // Make an API request to fetch details of selected plants based on their IDs
        axios.get(`http://localhost:8080/api/plants?ids=${selectedPlantIds.join(',')}`)
            .then((response) => {
                // Handle the response and update the state with plant details
                const selectedPlantsData = response.data;
                setGardenData((prevData) => ({
                    ...prevData,
                    plantedPlants: selectedPlantsData
                }));
            })
            .catch((error) => {
                // Handle errors (e.g., display an error message)
                console.error('Error fetching plant details:', error);
            });
    };

    const handleSaveGarden = () => {
        // Prepare the data to be sent to the backend
        const gardenDataToSave = {
            gardenName: gardenData.gardenName,
            selectedPlants: gardenData.selectedPlants,
            // Include relevant garden data here
        };

        // Send a POST request to create/update the garden
        axios.post('http://localhost:8080/api/gardens', gardenDataToSave)
            .then((response) => {
                // Handle the response as needed (e.g., show a success message)
                console.log('Garden saved successfully:', response.data);
            })
            .catch((error) => {
                // Handle errors (e.g., display an error message)
                console.error('Error saving the garden:', error);
            });
    }

    return (
        <Container>
            <Typography variant="h4" style={{ textAlign: 'center' }}>Your Custom Garden</Typography>
            <Paper elevation={3} style={{ padding: '16px' }}>
                <p>Garden Name: {gardenData.gardenName}</p>
                <Typography variant="h6">Selected Plants:</Typography>
                <Grid item xs={12} sm={6} md={4} lg={3} key={index}>
                    <img
                        src={plantedPlant.imageUrl}
                        alt={plantedPlant.plantName || "Plant Name Unavailable"} // Use a default value if plantName is undefined
                        style={{ width: '100%', height: 'auto' }}
                    />
                </Grid>

                <List>
                    {gardenData.selectedPlants.map((plantId, index) => (
                        <ListItem key={index}>
                            {/* Display plant details here */}
                            <p>{gardenData.plantedPlants[index]?.imageUrl || "Image Unavailable"}</p>

                            <p>{gardenData.plantedPlants[index]?.plantName || "Plant Name Unavailable"}</p>
                            {/*<p>{gardenData.plantedPlants[index]?.scientificName || "Scientific Name Unavailable"}</p>*/}
                            {/* Add more details as needed */}
                        </ListItem>
                    ))}
                </List>
            </Paper>
            <Button variant="contained" color="primary" onClick={handleSaveGarden}>
                Save Garden
            </Button>
            <Typography variant="h6" style={{ marginTop: '16px', textAlign: 'center' }}>This is your lovely virtual garden:</Typography>
            <Grid container spacing={2}>
                {/* Map through planted plant data and display images */}
                {gardenData.plantedPlants.map((plantedPlant, index) => (
                    <Grid item xs={12} sm={6} md={4} lg={3} key={index}>
                        <img
                            src={plantedPlant.imageUrl}
                            alt={plantedPlant.plantName || "Plant Name Unavailable"} // Use a default value if plantName is undefined
                            style={{ width: '100%', height: 'auto' }}
                        />
                    </Grid>
                ))}
            </Grid>
        </Container>
    );
};

export default CreatedGardenView;
