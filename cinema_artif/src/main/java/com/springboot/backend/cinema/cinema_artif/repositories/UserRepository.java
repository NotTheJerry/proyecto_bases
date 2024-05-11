package com.springboot.backend.cinema.cinema_artif.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.cinema.cinema_artif.entities.User;


public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
