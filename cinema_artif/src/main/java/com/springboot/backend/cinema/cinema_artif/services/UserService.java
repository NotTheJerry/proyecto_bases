package com.springboot.backend.cinema.cinema_artif.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.cinema.cinema_artif.entities.Role;
import com.springboot.backend.cinema.cinema_artif.entities.User;
import com.springboot.backend.cinema.cinema_artif.repositories.RoleRepository;
import com.springboot.backend.cinema.cinema_artif.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<User> findAll () {
        return (List<User>) repository.findAll();
    }

    @Transactional
    public User save ( User user ) {
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        
        optionalRoleUser.ifPresent(role -> roles.add(role));

        if(user.getAdmin()){
            System.out.println(user.getAdmin());
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(role -> roles.add(role));
        }

        user.setRoles(roles);

        
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }

    public boolean existsByUsername(String username){
        return repository.existsByUsername(username);
    }

}
