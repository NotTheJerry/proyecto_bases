package com.springboot.backend.cinema.cinema_artif.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.cinema.cinema_artif.entities.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
