import React from 'react';
import { Typography, Container } from '@mui/material';

const Footer = () => {
    return (
        <Container component="footer" sx={{ mt: 5 }}>
            <Typography variant="body2" color="textSecondary" align="center">
                &copy; {new Date().getFullYear()} Botanica Virtual Garden
            </Typography>
        </Container>
    );
};

export default Footer;
