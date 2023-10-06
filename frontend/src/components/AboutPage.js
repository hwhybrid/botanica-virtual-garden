import React from 'react';
import { Container, Typography } from '@mui/material';
import {  makeStyles } from '@mui/styles';


const useStyles = makeStyles((theme) => ({
    container: {
        paddingTop: theme.spacing(8),
        paddingBottom: theme.spacing(8),
    },
}));

function AboutPage() {
    const classes = useStyles();

    return (
        <Container className={classes.container}>
            <Typography variant="h4" gutterBottom>
                About Botanica Virtual Garden
            </Typography>
            <Typography variant="body1" paragraph>
                Botanica Virtual Garden is a place where you can explore a diverse
                collection of plants and create your own virtual garden.
            </Typography>
            <Typography variant="body1" paragraph>
                Our mission is to provide a platform for plant enthusiasts to connect,
                learn, and create beautiful virtual gardens.
            </Typography>
        </Container>
    );
}

export default AboutPage;
