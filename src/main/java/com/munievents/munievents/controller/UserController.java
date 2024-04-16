package com.munievents.munievents.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.munievents.munievents.entity.User;
import com.munievents.munievents.repository.UserRepository;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
public class UserController {

    @Autowired
    UserRepository ur;

    @GetMapping("/users")
    public List<User> all() {
        return this.ur.findAll();
    }

    @GetMapping("/users/{id}")
    public User oneById(@PathVariable("id") int id) {
        Optional<User> found = this.ur.findById(id);
        if(found.isEmpty()){
            return null;
        }
        return found.get();
    }

    @PostMapping("/users")
    public String add(@RequestBody User newUser) {
        User dbUser = this.ur.saveAndFlush(newUser);
        return "Usuario creado con id" + dbUser.getId();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        this.ur.deleteById(id);
        return "Usuario Eliminado";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User usuario) {
        User u = this.oneById(id);
        if (u == null) {
            return "No encontrado";
        }
        usuario.setId(id);
        this.ur.save(usuario);
        return "OK";
    }

}