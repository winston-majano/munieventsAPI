package com.munievents.munievents.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.munievents.munievents.entity.User;
import com.munievents.munievents.repository.UserRepository;


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
        return userRepository.findById(id);
    }

    //Crear un nuevo usuario
    public User saveAndFlush(User newUser) {
        return userRepository.saveAndFlush(newUser);
    }

    //Elimina un usuario por su ID
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    //Actualiza los datos de un usuario
    public User save(User usuario) {
        return userRepository.save(usuario);
    }

    public User  findOneByEmail(String email){
        User  login = userRepository.findOneByEmail(email);
        return  login;
    }
}
