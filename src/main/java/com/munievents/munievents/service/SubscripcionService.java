package com.munievents.munievents.service;

import java.util.List;
import java.util.Optional;

import com.munievents.munievents.entity.Subscripcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.munievents.munievents.repository.SubscripcionRepository;

@Service
public class SubscripcionService {
    @Autowired
    SubscripcionRepository subscripcionRepository;

    // TODO: retornamos todos los eventos
    public List<Subscripcion> getSubscripcions() {
        return subscripcionRepository.findAll();
    }

    // TODO: buscamos un evento por su id
    public Optional<Subscripcion> getSubscripcion(Long subscripId) {
        return subscripcionRepository.findById(subscripId);
    }

    // TODO:guarda o actualiza el subscripcion
    @PostMapping
    public void saveOrUpdate(@RequestBody Subscripcion subscripcion) {
        subscripcionRepository.save(subscripcion);
    }

    // TODO: elimina un subscripcion por su id
    public void delete(Long subscripId) {
        subscripcionRepository.deleteById(subscripId);
    }
}
