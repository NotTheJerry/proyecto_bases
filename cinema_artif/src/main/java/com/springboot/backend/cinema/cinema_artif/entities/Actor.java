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
@Table(name = "actores")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_actor;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    private String nombre;
    private String nacionalidad;
    private String correo;
    private String telefono;
    private String sexo;



}
