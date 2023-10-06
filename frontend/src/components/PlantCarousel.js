import React, {useEffect, useState} from 'react';
import { Container, Typography } from '@mui/material';
import {  makeStyles } from '@mui/styles';
import PlantCard from './PlantCard'; // Make sure to create this component
import axios from 'axios';

const useStyles = makeStyles((theme) => ({
    container: {
        paddingTop: theme.spacing(8),
        paddingBottom: theme.spacing(8),
    },
    title: {
        marginBottom: theme.spacing(4),
    },
}));

function PlantCarousel() {
    const classes = useStyles();

    const [plants, setPlants] = useState([]);

    useEffect(() => {
        const baseUrl = 'http://localhost:8080';

        // Define the API endpoint relative to the base URL
        const apiUrl = `${baseUrl}/api/plants/carouselOptions`;

        // Fetches plant data from the backend using Axios
        axios.get(apiUrl)
            .then((response) =>  {
                console.log('Plant data response:', response.data);

                // Set the fetched plant data in the state
                setPlants(response.data);
            })
            .catch((error) => {
                console.error('Error fetching plant data:', error);
        });
    }, []); // Fetches data once on component mount.

    return (
        <Container className={classes.container}>
            <Typography variant="h2" className={classes.title}>
                Plant Carousel
            </Typography>
            <div className="plant-carousel">
                {plants.map((plant) => (
                    <PlantCard key={plant.plantId} plant={plant} />
                ))}
            </div>
        </Container>
    );
}

export default PlantCarousel;
