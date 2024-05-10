package com.munievents.munievents.controller;

import java.util.*;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.munievents.munievents.entity.UserLogin;

import com.munievents.munievents.entity.User;
import com.munievents.munievents.service.UserService;


@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "User Controller")
public class UserController {

    private final UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> oneById(@PathVariable int id) {
        return userService.oneById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> add(@RequestBody User newUser) {

        return userService.saveAndFlush(newUser);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable int id) {
        userService.deleteById(id);
        return "Usuario Eliminado";
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User usuario) {
        ResponseEntity<User> u = userService.oneById(id);
        if (u == null) {
            return "No se ha actualizado correctamente";
        }
        usuario.setId(id);
        userService.save(usuario);
        return "OK, usuario actualizado";
    }

    @PostMapping("/usersLogin")
    public ResponseEntity<User> login(@RequestBody UserLogin userLogin) {
        Optional<User> usuarioOptional = userService.findOneByEmail(userLogin.getEmail());
        if (usuarioOptional.isPresent()) {
            User usuario = usuarioOptional.get();
            if (usuario.getPassword().equals(userLogin.getPassword())) {
                // Devuelve el objeto User en el cuerpo de la respuesta si la contraseña es correcta
                return ResponseEntity.ok(usuario);
            } else {
                // Devuelve un estado de no autorizado si la contraseña es incorrecta
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            // Devuelve un estado de no encontrado si el usuario no existe
            return ResponseEntity.notFound().build();
        }
    }
}
