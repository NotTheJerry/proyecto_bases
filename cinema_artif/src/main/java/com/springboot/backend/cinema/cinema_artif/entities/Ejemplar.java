package com.springboot.backend.cinema.cinema_artif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ejemplares")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_ejemplar;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "id_director")
    private Director director;

    private int cantidad;
    private String estado;


}
