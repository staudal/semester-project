package com.cloudrun.microservicetemplate.controllers;

import com.cloudrun.microservicetemplate.entities.User;
import com.cloudrun.microservicetemplate.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("Creating user: " + user);
        return userRepository.save(user);
    }

}
