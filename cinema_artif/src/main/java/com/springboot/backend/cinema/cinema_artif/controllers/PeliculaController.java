package com.springboot.backend.cinema.cinema_artif.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.cinema.cinema_artif.entities.General;
import com.springboot.backend.cinema.cinema_artif.entities.Pelicula;
import com.springboot.backend.cinema.cinema_artif.services.ActorService;
import com.springboot.backend.cinema.cinema_artif.services.DirectorService;
import com.springboot.backend.cinema.cinema_artif.services.EjemplarService;
import com.springboot.backend.cinema.cinema_artif.services.PeliculaService;


@RestController
@RequestMapping("/api/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService service;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private EjemplarService ejemplarService;

    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    public List<Pelicula> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view( @PathVariable Integer id) {
        Optional<Pelicula> peliculaOptional = service.findById(id);
        if(peliculaOptional.isPresent()){
            return ResponseEntity.ok(peliculaOptional.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Pelicula> save( @RequestBody Pelicula pelicula ){
        Pelicula peliculaSaved = service.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSaved);
    }

    @PostMapping("/save/all")
    public ResponseEntity<General> saveAll( @RequestBody General general ){

        System.out.println("Pelicula -> " + general.getPelicula());
        System.out.println("Director -> " + general.getDirector());
        System.out.println("Actor -> " + general.getActor());

        service.save(general.getPelicula());
        directorService.save(general.getDirector());
        // actorService.save(general.getActor());

        // System.out.println(general.toString());

        // general.getPelicula().getId_pelicula();

        // Pelicula peliculaSaved = service.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(general);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> update( @PathVariable Pelicula pelicula ){
        Pelicula peliculaSaved = service.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pelicula> delete( @PathVariable Integer id ){
        Pelicula pelicula = new Pelicula();
        pelicula.setId_pelicula(id);
        Optional<Pelicula> peliculaUpdated = service.delete(pelicula);
        if(peliculaUpdated.isPresent()){
            return ResponseEntity.ok(peliculaUpdated.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

}
