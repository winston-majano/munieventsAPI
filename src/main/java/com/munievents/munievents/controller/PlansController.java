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

import com.munievents.munievents.entity.Plans;
import com.munievents.munievents.service.PlansService;

@RestController
@RequestMapping(path = "api/v1")
public class PlansController {
    @Autowired
    private final PlansService plansService;

    public PlansController(PlansService plansService) {
        this.plansService = plansService;
    }


    //TODO: obtenemos todas las categorias
    @GetMapping("/plans")
    public List<Plans> getAll() {
        return plansService.getPlans();
    }

    @GetMapping("/plans/{idPlans}")
    public Optional<Plans> getById(@PathVariable("idPlans") Long plansId) {
        return plansService.getPlansById(plansId);
    }


    //TODO: enviamos el body una nueva categoria
    @PostMapping("/plans")
    public String savePlans(@RequestBody Plans plans) {
        plansService.saveOrUpdate(plans);
        return "Plano creado correctamente";
    }

    //TODO: actualizamos una categoria por su id
    @PutMapping("/plans/{id}")
    public String saveUpdatePlans(@PathVariable("id") Long plansId, @RequestBody Plans plans) {

        String message = "";
        try {
            if (plansService.getPlansById(plansId).isPresent()) {
                plansService.saveOrUpdate(plans);
                message = "Plano actualizado correctamente";
            } else {
                message = "Plano no existe";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }


    //TODO: enviamos como parametros el id de la categoria para eliminar una categoria
    @DeleteMapping("/plans/{id}")
    public String delete(@PathVariable("id") Long plansId) {
        plansService.delete(plansId);
        return "plano eliminado correctamente";
    }

}