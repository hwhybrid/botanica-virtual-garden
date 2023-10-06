import React, { useState } from 'react';
import { Container, Typography, TextField, Button } from '@mui/material';
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
    searchForm: {
        display: 'flex',
        flexDirection: 'column',
        gap: theme.spacing(2),
    },
}));

function SearchPage() {
    const classes = useStyles();

    // Define state to store search results
    const [searchResults, setSearchResults] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');

    const handleSearch = () => {
        // Make an Axios request to search for plants
        axios.get(`/api/plants/search?query=${searchQuery}`) // Adjust the endpoint URL
            .then((response) => {
                // Set the fetched search results in the state
                setSearchResults(response.data);
            })
            .catch((error) => {
                console.error('Error searching for plants:', error);
            });
    };

    return (
        <Container className={classes.container}>
            <Typography variant="h2" className={classes.title}>
                Search Plants
            </Typography>
            <div className={classes.searchForm}>
                <TextField
                    label="Search by plant name, edible, or scientific name"
                    variant="outlined"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
                <Button variant="contained" color="primary" onClick={handleSearch}>
                    Search
                </Button>
            </div>
            <div className="search-results">
                {/* Map through searchResults and render each plant */}
                {searchResults.map((plant) => (
                    <div key={plant.plantId}>
                        {/* Display plant details here */}
                    </div>
                ))}
            </div>
        </Container>
    );
}

export default SearchPage;
