import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import '../styles/PlantCarousel.css';

const PlantCarousel = () => {
    const [plants, setPlants] = useState([]);

    useEffect(() => {
        // Fetch plant data from your API
        axios
            .get('http://localhost:8080/api/plants/carouselOptions')
            .then((response) => {
                setPlants(response.data);
            })
            .catch((error) => {
                console.error('Error fetching plant data:', error);
            });
    }, []);

    return (
        <div className="plant-carousel-container">
            <h2>Plant Carousel</h2>
            <Carousel className="custom-carousel">
                {plants.map((plant) => (
                    <div key={plant.plantId} className="plant-slide">
                        <div className="image-container">
                            <img
                                src={plant.imageUrl}
                                alt={plant.plantName}
                                className="image"
                            />
                        </div>
                        <div className="plant-info">
                            <h3>{plant.plantName}</h3>
                            <p>Scientific Name: {plant.scientificName}</p>
                            <p>Description: {plant.plantDescription}</p>
                            <p>Edible: {plant.edible ? 'Yes' : 'No'}</p>
                        </div>
                    </div>
                ))}
            </Carousel>
        </div>
    );
};

export default PlantCarousel;
