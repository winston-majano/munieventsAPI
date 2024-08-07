package com.munievents.munievents.controller;

import com.munievents.munievents.entity.Event;
import com.munievents.munievents.entity.dto.EventUserDTO;
import com.munievents.munievents.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin(origins = "*")
@Tag(name = "Events Controller")
public class EventController {

    @Autowired
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    //TODO: obtenemos todos los eventos
    @GetMapping("/events")
    public List<EventUserDTO> getAll() {
        return eventService.getEvents();
    }

    @GetMapping("/events/{idEvent}")
    public Optional<Event> getById(@PathVariable("idEvent") int eventId) {
        return eventService.getEvent(eventId);
    }


    //TODO: enviamos el body un nuevo evento
    @PostMapping("/events")
    public ResponseEntity<String> saveEvent(@RequestBody Event event) {
        eventService.saveOrUpdate(event);
        return new ResponseEntity("Evento Creado Correctamente",HttpStatus.OK);
    }

    //TODO: actualizamos un evento por su id
    @PutMapping("/events/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable("id") int eventId, @RequestBody Event event) {

        return new ResponseEntity<String>(eventService.updateEvent(eventId, event), HttpStatus.OK);
    }


    //TODO: enviamos como parametros el id del evento para eliminar el vento
    @DeleteMapping("/events/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int eventId) {
        return new ResponseEntity<>(eventService.delete(eventId), HttpStatus.OK);
    }

    //TODO: ejemplo de JPQL para mostrar solo un dato del query personalizado
    @GetMapping("/events/jpql/{idEvent}")
    public String getNameEventoById(@PathVariable("idEvent") int idEvent) {
        return eventService.getNameEventoById(idEvent);
    }

    //TODO: eventos listados filtrados por usuario.
    @GetMapping("/events/user/{idUser}")
    public List<EventUserDTO>  getAllEventByUser(@PathVariable("idUser") int userId) {
        return eventService.findAllEventByUserId(userId);
    }


}
