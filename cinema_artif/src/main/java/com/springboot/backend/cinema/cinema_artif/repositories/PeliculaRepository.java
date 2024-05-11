package com.springboot.backend.cinema.cinema_artif.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.cinema.cinema_artif.entities.Pelicula;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer> {
}
