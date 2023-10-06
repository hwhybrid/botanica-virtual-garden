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
import GardenView from "./components/CreatedGardenView";
import CreateGardenPage from "./components/CreateGardenPage";
import Login from "./components/Login";
import Register from "./components/Register";
import CreatedGardenView from "./components/CreatedGardenView";

function App() {
  return (
      <div>
        <Header />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/carousel" element={<PlantCarousel />} />
          <Route path="/create-garden" element={<CreateGardenPage />} />
          <Route path="/created-garden-view" element={<CreatedGardenView />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/user/gardens" element={<UserGardensPage />} />
          <Route path="/search" element={<SearchPage />} />

      </Routes>
        <Footer />
      </div>
  );
}

export default App;