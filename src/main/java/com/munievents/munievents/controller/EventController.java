package com.munievents.munievents.controller;

import com.munievents.munievents.entity.Event;
import com.munievents.munievents.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:8080"})
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
    public Optional<Event> getById(@PathVariable("idEvent") int eventId) {
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
    public String saveUpdateEvent(@PathVariable("id") int eventId, @RequestBody Event event) {

        String message = "";
        try {
            if (eventService.getEvent(eventId).isPresent()) {
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
    public String delete(@PathVariable("id") int eventId) {
        eventService.delete(eventId);
        return "Evento eliminado correctamente";
    }

    //TODO: ejemplo de JPQL para mostrar solo un dato del query personalizado
    @GetMapping("/events/jpql/{idEvent}")
    public String getNameEventoById(@PathVariable("idEvent") int idEvent) {
        return eventService.getNameEventoById(idEvent);
    }

}
