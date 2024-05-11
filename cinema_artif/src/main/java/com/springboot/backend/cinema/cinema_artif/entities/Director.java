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
@Data
@Table(name = "director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_director;

    private String nombre;
    private String nacionalidad;
    private String correo;
    
    @OneToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    @OneToOne
    @JoinColumn(name = "id_ejemplar")
    private Ejemplar ejemplar;


}
