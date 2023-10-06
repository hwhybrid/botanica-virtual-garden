import React from 'react';
import { Container, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

const Register = () => {
    // Add your registration logic here

    return (
        <Container>
            <Typography variant="h4">Register</Typography>
            {/* Add registration form and logic here */}
            <Link to="/login">
                <Button variant="outlined" color="primary">
                    Login
                </Button>
            </Link>
        </Container>
    );
};

export default Register;
