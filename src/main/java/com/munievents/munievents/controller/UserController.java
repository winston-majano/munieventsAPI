
package com.munievents.munievents.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.munievents.munievents.entity.User;
import com.munievents.munievents.entity.UserLogin;
import com.munievents.munievents.entity.UserUpdate;
import com.munievents.munievents.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*")
@Tag(name = "User Controller")
public class UserController {

    private final UserService userService;
    private static final String UPLOAD_DIR = "uploads/";

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAllActive();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> oneById(@PathVariable int id) {
        Optional<User> userOptional = userService.oneByIdActive(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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

    // @PostMapping("/users")
    // public ResponseEntity<User> add(
    // @RequestParam("full_name") String fullName,
    // @RequestParam("email") String email,
    // @RequestParam("phone") String phone,
    // @RequestParam("alias") String alias,
    // @RequestParam("password") String password,
    // @RequestParam("image_user") MultipartFile imageFile) {
    // String imageUrl = saveImage(imageFile);
    // if (imageUrl == null) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // }

    // User newUser = new User();
    // newUser.setFull_name(fullName);
    // newUser.setEmail(email);
    // newUser.setPhone(phone);
    // newUser.setAlias(alias);
    // newUser.setPassword(password);
    // newUser.setImage_user(imageUrl);

    // return userService.saveAndFlush(newUser);
    // }

    @PostMapping("/users")
    public ResponseEntity<User> add(
            @RequestParam("full_name") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("alias") String alias,
            @RequestParam("password") String password,
            @RequestParam(value = "image_user", required = false) MultipartFile imageFile) {
        String imageUrl = (imageFile != null && !imageFile.isEmpty()) ? saveImage(imageFile) : null;

        User newUser = new User();
        newUser.setFull_name(fullName);
        newUser.setEmail(email);
        newUser.setPhone(phone);
        newUser.setAlias(alias);
        newUser.setPassword(password);
        newUser.setImage_user(imageUrl);

        return userService.saveAndFlush(newUser);
    }

    // @PutMapping("/users/{id}")
    // public ResponseEntity<User> updateUser(@PathVariable int id,
    //         @RequestParam("full_name") String fullName,
    //         @RequestParam("email") String email,
    //         @RequestParam("phone") String phone,
    //         @RequestParam("alias") String alias,
    //         @RequestParam("image_user") MultipartFile imageFile) {
    //     Optional<User> userOptional = userService.oneByIdActive(id);
    //     if (!userOptional.isPresent()) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     User usuario = userOptional.get();
    //     String imageUrl = saveImage(imageFile);
    //     if (imageUrl != null) {
    //         usuario.setImage_user(imageUrl);
    //     }
    //     usuario.setEmail(email);
    //     usuario.setPhone(phone);
    //     usuario.setFull_name(fullName);
    //     usuario.setAlias(alias);

    //     User updatedUser = userService.save(usuario);
    //     return ResponseEntity.ok(updatedUser);
    // }

    private String saveImage(MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }

        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, file.getBytes());
            return fileName; // Solo el nombre del archivo
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,
            @RequestParam("full_name") String fullName,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("alias") String alias,
            @RequestParam(value = "image_user", required = false) MultipartFile imageFile) {
        Optional<User> userOptional = userService.oneByIdActive(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User usuario = userOptional.get();
        String imageUrl = (imageFile != null && !imageFile.isEmpty()) ? saveImage(imageFile) : usuario.getImage_user();

        usuario.setEmail(email);
        usuario.setPhone(phone);
        usuario.setFull_name(fullName);
        usuario.setAlias(alias);
        usuario.setImage_user(imageUrl);

        User updatedUser = userService.save(usuario);
        return ResponseEntity.ok(updatedUser);
    }
}
