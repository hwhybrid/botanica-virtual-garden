import React from 'react';
import { Container, Typography, Button } from '@mui/material';
import { Link } from 'react-router-dom';

const Login = () => {
    // Add your login logic here

    return (
        <Container>
            <Typography variant="h4">Login</Typography>
            {/* Add login form and logic here */}
            <Link to="/register">
                <Button variant="outlined" color="primary">
                    Register
                </Button>
            </Link>
        </Container>
    );
};

export default Login;
