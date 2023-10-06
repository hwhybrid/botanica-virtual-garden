// CreateGardenPage.js
import React, { useState, useEffect } from 'react';
import {
    Container,
    Typography,
    TextField,
    Button,
    Grid,
    Paper,
    Checkbox
} from '@mui/material';

import { makeStyles } from '@mui/styles';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const useStyles = makeStyles((theme) => ({
    paper: {
        padding: '16px',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        width: '200px',
        minHeight: '370px', // Increased height to accommodate larger images and additional padding
        borderRadius: '10px', // Add border radius
    },
    image: {
        width: '77px', // Increase image size by 10%
        height: '77px', // Increase image size by 10%
        marginBottom: '16px',
        borderRadius: '5px', // Add border radius to round edges
    },
    plantName: {
        textAlign: 'center',
    },
    plantInfo: {
        textAlign: 'left',
    },
    button: {
        marginTop: '16px', // Add some margin to the button for spacing
    },
}));

const CreateGardenPage = () => {
    const [gardenName, setGardenName] = useState('');
    const [selectedPlantIds, setSelectedPlantIds] = useState([]);
    const [availablePlants, setAvailablePlants] = useState([]);
    const navigate = useNavigate();
    const classes = useStyles();

    useEffect(() => {
        // Fetch the list of available plants from your backend API
        axios.get('http://localhost:8080/api/plants').then((response) => {
            setAvailablePlants(response.data);
        });
    }, []);

    const handlePlantSelection = (plantId) => {
        if (selectedPlantIds.includes(plantId)) {
            setSelectedPlantIds(selectedPlantIds.filter((id) => id !== plantId));
        } else {
            setSelectedPlantIds([...selectedPlantIds, plantId]);
        }
    };

    const handleGenerateGarden = () => {
        // Navigate to the CreatedGardenView component with selected plant IDs
        navigate(`/created-garden-view?selectedPlants=${selectedPlantIds.join(',')}`);
    };

    return (
        <Container>
            <Typography variant="h4">Create a New Garden</Typography>
            <form>
                <TextField
                    label="Garden Name"
                    variant="outlined"
                    fullWidth
                    value={gardenName}
                    onChange={(e) => setGardenName(e.target.value)}
                    required
                />
                <Typography variant="h6" gutterBottom>
                    Select Plants:
                </Typography>
                <Grid container spacing={2}>
                    {availablePlants.map((plant) => (
                        <Grid item xs={12} sm={6} md={4} lg={3} key={plant.plantId}>
                            <Paper elevation={3} className={classes.paper} style={{ minHeight: '370px'}}>
                                <Checkbox
                                    checked={selectedPlantIds.includes(plant.plantId)}
                                    onChange={() => handlePlantSelection(plant.plantId)}
                                />
                                <img
                                    src={plant.imageUrl}
                                    alt={plant.plantName}
                                    className={classes.image}
                                />
                                <div className={classes.plantName}>
                                    <p><strong>{plant.plantName}</strong></p>
                                </div>
                                <div className={classes.plantInfo}>
                                    <p><strong>Scientific Name:</strong> <i>{plant.scientificName}</i></p>
                                    <p><strong>Description:</strong> {plant.plantDescription}</p>
                                    <p><strong>Edible:</strong> {plant.edible ? 'Yes' : 'No'}</p>
                                </div>
                            </Paper>
                        </Grid>
                    ))}
                </Grid>
                <Button type="button" variant="contained" color="primary" onClick={handleGenerateGarden} className={classes.button}>
                    Generate Garden
                </Button>
            </form>
        </Container>
    );
};

export default CreateGardenPage;
