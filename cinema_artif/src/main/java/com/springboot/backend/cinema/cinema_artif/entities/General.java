package com.springboot.backend.cinema.cinema_artif.entities;

import lombok.Data;

@Data
public class General {

    private Pelicula pelicula;
    private Director director;
    private Ejemplar ejemplar;
    private Actor actor;


}
