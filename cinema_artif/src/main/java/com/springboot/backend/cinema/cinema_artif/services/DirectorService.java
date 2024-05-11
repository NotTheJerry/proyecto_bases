package com.springboot.backend.cinema.cinema_artif.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.cinema.cinema_artif.entities.Director;
import com.springboot.backend.cinema.cinema_artif.repositories.DirectorRepository;


@Service
public class DirectorService {

    @Autowired
    private DirectorRepository repository;

    @Transactional(readOnly = true)
    public List<Director> findAll(){
        return (List<Director>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Director> findById(Integer id){
        return repository.findById(id);
    }

    @Transactional
    public Director save(Director director){
        return repository.save(director);
    }

    @Transactional
    public Optional<Director> delete (Director director){
        Optional<Director> peliculaDB = repository.findById(director.getId_director());
        peliculaDB.ifPresent(pel -> {
            repository.delete(pel);
        });
        return peliculaDB;
    }
}
