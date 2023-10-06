import React, { useEffect, useState } from 'react';
import { Container, Typography } from '@mui/material';
import { makeStyles } from '@mui/styles';
import axios from 'axios'; // You'll need to import Axios

const useStyles = makeStyles((theme) => ({
    container: {
        paddingTop: theme.spacing(8),
        paddingBottom: theme.spacing(8),
    },
    title: {
        marginBottom: theme.spacing(4),
    },
}));

function UserGardensPage() {
    const classes = useStyles();

    // Define state to store user gardens
    const [userGardens, setUserGardens] = useState([]);

    useEffect(() => {
        // Make an Axios request to fetch user's gardens
        axios.get('/api/user/gardens') // Adjust the endpoint URL
            .then((response) => {
                // Set the fetched user gardens in the state
                setUserGardens(response.data);
            })
            .catch((error) => {
                console.error('Error fetching user gardens:', error);
            });
    }, []); // Fetches data once on component mount.

    return (
        <Container className={classes.container}>
            <Typography variant="h2" className={classes.title}>
                User Gardens
            </Typography>
            <div className="user-gardens-list">
                {/* Map through userGardens and render each garden */}
                {userGardens.map((garden) => (
                    <div key={garden.id}>
                        {/* Display garden details here */}
                    </div>
                ))}
            </div>
        </Container>
    );
}

export default UserGardensPage;
