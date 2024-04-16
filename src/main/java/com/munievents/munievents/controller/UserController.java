package com.munievents.munievents.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munievents.munievents.entity.User;
import com.munievents.munievents.service.UserService;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> all() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User oneById(@PathVariable int id) {
        return userService.oneById(id).orElse(null);
    }

    @PostMapping("/users")
    public User add(@RequestBody User newUser) {
        return userService.saveAndFlush(newUser);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable int id) {
        userService.deleteById(id);
        return "Usuario Eliminado";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User usuario) {
        User u = userService.oneById(id).orElse(null);
        if (u == null) {
            return "No encontrado";
        }
        usuario.setId(id);
        userService.save(usuario);
        return "OK";
    }
}
