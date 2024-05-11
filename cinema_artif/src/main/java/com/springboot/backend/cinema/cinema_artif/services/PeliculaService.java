package com.springboot.backend.cinema.cinema_artif.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.cinema.cinema_artif.entities.Pelicula;
import com.springboot.backend.cinema.cinema_artif.repositories.PeliculaRepository;


@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repository;

    @Transactional(readOnly = true)
    public List<Pelicula> findAll(){
        return (List<Pelicula>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Pelicula> findById(Integer id){
        return repository.findById(id);
    }

    @Transactional
    public Pelicula save(Pelicula pelicula){
        return repository.save(pelicula);
    }

    @Transactional
    public Optional<Pelicula> delete (Pelicula pelicula){
        Optional<Pelicula> peliculaDB = repository.findById(pelicula.getId_pelicula());
        peliculaDB.ifPresent(pel -> {
            repository.delete(pel);
        });
        return peliculaDB;
    }
}
