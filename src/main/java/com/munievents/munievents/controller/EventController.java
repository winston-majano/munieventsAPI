package com.munievents.munievents.controller;

import com.munievents.munievents.entity.Event;
import com.munievents.munievents.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class EventController {

    @Autowired
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //TODO: obtenemos todos los eventos
    @GetMapping("/events")
    public List<Event> getAll() {
        return eventService.getEvents();
    }

    @GetMapping("/events/{idEvent}")
    public Optional<Event> getById(@PathVariable("idEvent") Long eventId) {
        return eventService.getEvent(eventId);
    }


    //TODO: enviamos el body un nuevo evento
    @PostMapping("/events")
    public String saveEvent(@RequestBody Event event) {
        eventService.saveOrUpdate(event);
        return "Evento creado correctamente";
    }

    //TODO: actualizamos un evento por su id
    @PutMapping("/events/{id}")
    public String saveUpdateEvent(@PathVariable("id") Long eventId, @RequestBody Event event) {

        String message = "";
        try {
            if (!eventService.getEvent(eventId).isEmpty()) {
                eventService.saveOrUpdate(event);
                message = "Evento actualizado correctamente";
            } else {
                message = "Evento no existe";
            }
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        return message;
    }


    //TODO: enviamos como parametros el id del evento para eliminar el vento
    @DeleteMapping("/events/{id}")
    public String delete(@PathVariable("id") Long eventId) {
        eventService.delete(eventId);
        return "Evento eliminado correctamente";

    }
}
