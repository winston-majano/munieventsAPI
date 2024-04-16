package com.munievents.munievents.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.munievents.munievents.entity.Subscripcion;
import com.munievents.munievents.service.SubscripcionService;

@RestController
@RequestMapping(path = "api/subscripcion")
public class SubscripcionController {
    
    @Autowired
    private final SubscripcionService subscripService;

    public SubscripcionController(SubscripcionService subscripService) {
        this.subscripService = subscripService;
    }

    @GetMapping("/subscripcions")
    public List<Subscripcion> getAll() {
        return subscripService.getSubscripcions();
    }

    @GetMapping("/subscripcions/{idSubscrip}")
    public Optional<Subscripcion> getById(@PathVariable("idSubscrip") Long subscripId) {
        return subscripService.getSubscripcion(subscripId);
    }

    @PostMapping("/subscripcion")
    public String saveSubscripcion(@RequestBody Subscripcion subscripcion) {
        subscripService.saveOrUpdate(subscripcion);
        return "Subscripcion creada correctamente";
    }

    @PutMapping("/subscripcion/{id}")
    public String updateSubscripcion(@PathVariable("id") int subscripId, @RequestBody Subscripcion subscripcion) {
        String message = "";
        try {
            if (subscripService.getSubscripcion((long) subscripId).isPresent()) {
                subscripcion.setId(subscripId); 
                subscripService.saveOrUpdate(subscripcion);
                message = "Subscripcion actualizada correctamente";
            } else {
                message = "Subscripcion no existe";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }

    @DeleteMapping("/subscripcions/{id}")
    public String deleteSubscripcion(@PathVariable("id") Long subscripId) {
        subscripService.delete(subscripId);
        return "Subscripcion eliminada correctamente";
    }
}
