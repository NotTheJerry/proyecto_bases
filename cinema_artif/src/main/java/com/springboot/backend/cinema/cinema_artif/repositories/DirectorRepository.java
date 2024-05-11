package com.springboot.backend.cinema.cinema_artif.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.cinema.cinema_artif.entities.Director;

public interface DirectorRepository extends CrudRepository<Director, Integer> {
}
