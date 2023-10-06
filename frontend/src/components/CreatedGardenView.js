import React from 'react';
import { Container, Typography, Paper, Button } from '@mui/material';
import axios from "axios";

const CreatedGardenView = () => {
    // You can fetch garden data and display it here

    const handleSaveGarden = () => {
        // Prepare the data to be sent to the backend
        const gardenData = {
            // Include relevant garden data here
        };

        // Send a POST request to create the garden
        axios.post('http://localhost:8080/api/gardens', gardenData)
            .then((response) => {
                // Handle the response as needed (e.g., show a success message)
            })
            .catch((error) => {
                // Handle errors (e.g., display an error message)
                console.error('Error saving the garden:', error);
            });

    }

    return (
        <Container>
            <Typography variant="h4">Your Created Garden</Typography>
            <Paper elevation={3} style={{ padding: '16px' }}>
                {/* Display the garden content here */}
                {/* You can fetch garden data and display it */}
            </Paper>
            <Button variant="contained" color="primary" onClick={handleSaveGarden}>
                Save Garden
            </Button>
        </Container>
    );
};

export default CreatedGardenView;
