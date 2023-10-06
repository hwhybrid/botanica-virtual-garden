import React from 'react';
import { Container, Typography } from '@mui/material';
import {  makeStyles } from '@mui/styles';

const useStyles = makeStyles((theme) => ({
    container: {
        paddingTop: theme.spacing(8),
        paddingBottom: theme.spacing(8),
    },
}));

function ContactPage() {
    const classes = useStyles();

    return (
        <Container className={classes.container}>
            <Typography variant="h4" gutterBottom>
                Contact Us
            </Typography>
            <Typography variant="body1" paragraph>
                If you have any questions, suggestions, or feedback, please feel free to
                get in touch with us.
            </Typography>
            <Typography variant="body1" paragraph>
                Email: info@botanicagarden.com
            </Typography>
        </Container>
    );
}

export default ContactPage;
