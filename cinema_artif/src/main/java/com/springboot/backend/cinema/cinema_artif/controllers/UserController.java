package com.springboot.backend.cinema.cinema_artif.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.cinema.cinema_artif.entities.User;
import com.springboot.backend.cinema.cinema_artif.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> list () {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create( @Valid @RequestBody User user, BindingResult result) {
        if(result.hasFieldErrors()){
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }


    @PostMapping("/register")
    public ResponseEntity<?> register( @Valid @RequestBody User user, BindingResult result) {
        user.setAdmin(false);
        return create(user, result);
    }

    private ResponseEntity<?> validation ( BindingResult result ) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
    

}
