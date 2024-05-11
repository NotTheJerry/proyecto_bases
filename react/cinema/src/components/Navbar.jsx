import '../styles/navbar.css'
import cinemaLogo from "../svg/cinema_logo.svg"

import React from 'react';

  const handleLogout = () => {
    localStorage.removeItem('token');
    window.location.href = '/login';
  };



export const NavBar = () => {

    return (
        <div className="div_padre">
            <div className='nombre_del_sitio'>
                <img src={ cinemaLogo } alt="Cinema Logo" />
                <h1>CINEMA</h1>
            </div>
            <div className='secciones'>
                <a href="/inicio">Inicio</a>
                <a href="/register">Register</a>
                <a href="/guardar-pelicula">Guardar</a>
                <p onClick={handleLogout}>Logout</p>
            </div>
        </div>
    )

}