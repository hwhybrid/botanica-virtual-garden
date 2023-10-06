import React from 'react';
import { Card, CardContent, Typography, CardMedia} from '@mui/material';
import { makeStyles } from '@mui/styles';

const useStyles = makeStyles((theme) => ({
    card: {
        maxWidth: 345,
        margin: theme.spacing(2),
    },
    media: {
        height: 200,
    },
}));

function PlantCard({ plant }) {
    const classes = useStyles();

    return (
        <Card className={classes.card}>
            <CardMedia className={classes.media}
                       image={`/plant_images/${plant.imageUrl}`}
                       title={plant.plantName} />
            <CardContent>
                <Typography variant="h6" gutterBottom>
                    {plant.plantName}
                </Typography>
                <Typography variant="body2" color="textSecondary" paragraph>
                    Scientific Name: {plant.scientificName}
                </Typography>
                <Typography variant="body2" paragraph>
                    Description: {plant.plantDescription}
                </Typography>
                <Typography variant="body2" color="textSecondary" paragraph>
                    Edible: {plant.edible ? 'Yes' : 'No'}
                </Typography>
            </CardContent>
        </Card>
    );
}

export default PlantCard;
