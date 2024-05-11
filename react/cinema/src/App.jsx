import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import { Login } from './pages/Login';
import { Inicio } from './pages/Inicio';
import { Register } from './pages/Register';
import { GuardarPelicula } from './pages/GuardarPelicula';
import { jwtDecode } from 'jwt-decode';

// Función para verificar si hay un token válido
const verificarToken = () => {
  const token = localStorage.getItem('token');
  // const decoded = jwtDecode(token);
  // console.log("Token: ", decoded.authorities.includes("ROLE_ADMIN"));
  return !!token;
};

// Componente de ruta protegida
const RutaProtegida = ({ element, ...rest }) => {
  return verificarToken() ? (
    element
  ) : (
    <Navigate to="/login" replace />
  );
}

const RutaAdmin = ({ element, ...rest }) => {
  const token = localStorage.getItem('token');
    const decoded = jwtDecode(token);
    // console.log(decoded);
  return decoded.authorities.includes("ROLE_ADMIN") ? (
    element
  ) : (
    <Navigate to="/inicio" replace />
  );
}

export function App() {
  return (
    <div>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/inicio" element={<RutaProtegida element={<Inicio />} />} />
        <Route path="/guardar-pelicula" element={<RutaAdmin element={<GuardarPelicula />} />} />
      </Routes>
    </div>
  );
}
