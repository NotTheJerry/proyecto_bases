package com.springboot.backend.cinema.cinema_artif.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.cinema.cinema_artif.entities.Actor;
import com.springboot.backend.cinema.cinema_artif.repositories.ActorRepository;


@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

    @Transactional(readOnly = true)
    public List<Actor> findAll(){
        return (List<Actor>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Actor> findById(Integer id){
        return repository.findById(id);
    }

    @Transactional
    public Actor save(Actor actor){
        return repository.save(actor);
    }

    @Transactional
    public Optional<Actor> delete (Actor actor){
        Optional<Actor> peliculaDB = repository.findById(actor.getId_actor());
        peliculaDB.ifPresent(pel -> {
            repository.delete(pel);
        });
        return peliculaDB;
    }
}
