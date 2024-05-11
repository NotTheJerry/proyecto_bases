package com.springboot.backend.cinema.cinema_artif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="pelicula")
@Data
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_pelicula; 

    @OneToOne
    @JoinColumn(name = "id_actor")
    private Actor actor;

    @OneToOne
    @JoinColumn(name = "id_ejemplar")
    private Ejemplar ejemplar;

    @OneToOne
    @JoinColumn(name = "id_director")
    private Director director;
    private String titulo;
    private String nacionalidad;
    private String productores;
    private String fecha;

}
