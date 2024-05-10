package com.munievents.munievents.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.munievents.munievents.entity.User;
import com.munievents.munievents.repository.UserRepository;

import javax.swing.text.html.Option;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Devuelve todos los usuarios
    public List<User> getAll() {
        return userRepository.findAll();
    }

    //Devuelve un usuario seleccionado por ID
    public Optional<User> oneById(int id) {
        Optional<User> userById = userRepository.findById(id);

       // System.out.println("Que viene: "+UserById);
        return userById;

        //return new ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

    //Crear un nuevo usuario
    public ResponseEntity<User> saveAndFlush(User newUser) {
        Optional<User> nuevoUser = userRepository.findOneByEmail(newUser.getEmail());
        if (nuevoUser.isPresent()) {
          
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return new ResponseEntity<User>(userRepository.saveAndFlush(newUser), HttpStatus.OK);
    }

    //Elimina un usuario por su ID
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    //Actualiza los datos de un usuario
    public User save(User usuario) {
        return userRepository.save(usuario);
    }

    public Optional<User>  findOneByEmail(String email){
        Optional<User>  login = userRepository.findOneByEmail(email);
        return  login;
    }
}
