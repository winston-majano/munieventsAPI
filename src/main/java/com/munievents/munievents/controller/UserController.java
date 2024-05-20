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
import com.munievents.munievents.entity.UserUpdate;
import com.munievents.munievents.entity.User;
import com.munievents.munievents.service.UserService;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*")
@Tag(name = "User Controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // @GetMapping("/users")
    // public List<User> getAll() {
    // return userService.getAll();
    // }

    // Para retornar solo los usuarios activos.
    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAllActive();
    }

    // @GetMapping("/users/{id}")
    // public Optional<User> oneById(@PathVariable int id) {
    // return userService.oneById(id);
    // }

    // Retorna los usuarios por ID que tengan el status activo
    @GetMapping("/users/{id}")
    public ResponseEntity<User> oneById(@PathVariable int id) {
        Optional<User> userOptional = userService.oneByIdActive(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> add(@RequestBody User newUser) {

        return userService.saveAndFlush(newUser);
    }

    // @DeleteMapping("/users/{id}")
    // public String deleteUserById(@PathVariable int id) {
    // userService.deleteById(id);
    // return "Usuario Eliminado";
    // }

    @DeleteMapping("/users/{id}")
    public String deactivateUserById(@PathVariable int id) {
        Optional<User> userOptional = userService.oneById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setStatus("D");
            userService.save(user);
            return "Usuario desactivado";
        } else {
            return "Usuario no encontrado";
        }
    }

    // PutMapping que funcionaba antes de bloquear el password en el get

    // @PutMapping("/users/{id}")
    // public String updateUser(@PathVariable int id, @RequestBody User usuario) {
    // Optional<User> userUpdate = userService.oneById(id);
    // if (!userUpdate.isPresent()) {
    // return "No se ha actualizado correctamente";
    // }
    // usuario.setId(id);
    // userService.save(usuario);
    // return "OK, usuario actualizado";
    // }

    // @PutMapping("/users/{id}")
    // public String updateUser(@PathVariable int id, @RequestBody UserUpdate
    // userUpdate) {
    // Optional<User> userUpgrade = userService.oneById(id);
    // if (!userUpgrade.isPresent()) {
    // return "No se ha actualizado correctamente";
    // }

    // User usuario = userUpgrade.get();
    // usuario.setImage_user(userUpdate.getImage_user());
    // usuario.setEmail(userUpdate.getEmail());
    // usuario.setPhone(userUpdate.getPhone());
    // usuario.setFull_name(userUpdate.getFull_name());
    // usuario.setAlias(userUpdate.getAlias());
    // usuario.setQty_event_sub(userUpdate.getQty_event_sub());

    // userService.save(usuario);
    // return "OK, usuario actualizado";
    // }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody UserUpdate userUpdate) {
        Optional<User> userOptional = userService.oneByIdActive(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User usuario = userOptional.get();
        usuario.setImage_user(userUpdate.getImage_user());
        usuario.setEmail(userUpdate.getEmail());
        usuario.setPhone(userUpdate.getPhone());
        usuario.setFull_name(userUpdate.getFull_name());
        usuario.setAlias(userUpdate.getAlias());
        usuario.setQty_event_sub(userUpdate.getQty_event_sub());

        userService.save(usuario);
        return ResponseEntity.ok("OK, usuario actualizado");
    }

    // @PostMapping("/usersLogin")
    // public ResponseEntity<User> login(@RequestBody UserLogin userLogin) {
    //     Optional<User> usuarioOptional = userService.findOneByEmail(userLogin.getEmail());
    //     if (usuarioOptional.isPresent()) {
    //         User usuario = usuarioOptional.get();
    //         if (usuario.getPassword().equals(userLogin.getPassword())) {
    //             // Devuelve el objeto User en el cuerpo de la respuesta si la contraseña es
    //             // correcta
    //             return ResponseEntity.ok(usuario);
    //         } else {
    //             // Devuelve un estado de no autorizado si la contraseña es incorrecta
    //             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //         }
    //     } else {
    //         // Devuelve un estado de no encontrado si el usuario no existe
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @PostMapping("/usersLogin")
    public ResponseEntity<User> login(@RequestBody UserLogin userLogin) {
        Optional<User> usuarioOptional = userService.findOneByEmailAndStatus(userLogin.getEmail(), "A");
        if (usuarioOptional.isPresent()) {
            User usuario = usuarioOptional.get();
            if (usuario.getPassword().equals(userLogin.getPassword())) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
