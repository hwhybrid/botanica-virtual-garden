import React from 'react';
import { Container, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';
import {  makeStyles } from '@mui/styles';


const useStyles = makeStyles((theme) => ({
    container: {
        paddingTop: theme.spacing(8),
        paddingBottom: theme.spacing(8),
        textAlign: 'center',
    },
    button: {
        marginTop: theme.spacing(4),
    },
}));

function HomePage() {
    const classes = useStyles();

    return (
        <Container className={classes.container}>
            <Typography variant="h3" gutterBottom>
                Welcome to Botanica Virtual Garden
            </Typography>
            <Typography variant="body1" paragraph>
                Explore a world of beautiful plants and create your own virtual garden.
            </Typography>
            <Button
                component={Link}
                to="/carousel"
                variant="contained"
                color="primary"
                size="large"
                className={classes.button}
            >
                Explore Plants
            </Button>
        </Container>
    );
}

export default HomePage;
