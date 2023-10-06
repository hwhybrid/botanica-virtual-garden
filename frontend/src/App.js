import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import HomePage from './components/HomePage';
import AboutPage from './components/AboutPage';
import ContactPage from './components/ContactPage';
import PlantCarousel from './components/PlantCarousel';
import UserGardensPage from './components/UserGardensPage';
import SearchPage from './components/SearchPage';

function App() {
  return (
      <div>
        <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/carousel" element={<PlantCarousel />} />
        <Route path="/user/gardens" element={<UserGardensPage />} />
        <Route path="/search" element={<SearchPage />} />
      </Routes>
        <Footer />
      </div>
  );
}

export default App;