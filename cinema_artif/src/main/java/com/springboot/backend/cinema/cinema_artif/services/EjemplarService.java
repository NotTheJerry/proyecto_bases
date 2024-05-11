package com.springboot.backend.cinema.cinema_artif.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.cinema.cinema_artif.entities.Ejemplar;
import com.springboot.backend.cinema.cinema_artif.repositories.EjemplarRepository;


@Service
public class EjemplarService {

    @Autowired
    private EjemplarRepository repository;

    @Transactional(readOnly = true)
    public List<Ejemplar> findAll(){
        return (List<Ejemplar>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Ejemplar> findById(Integer id){
        return repository.findById(id);
    }

    @Transactional
    public Ejemplar save(Ejemplar ejemplar){
        return repository.save(ejemplar);
    }

    @Transactional
    public Optional<Ejemplar> delete (Ejemplar ejemplar){
        Optional<Ejemplar> peliculaDB = repository.findById(ejemplar.getId_ejemplar());
        peliculaDB.ifPresent(pel -> {
            repository.delete(pel);
        });
        return peliculaDB;
    }
}
