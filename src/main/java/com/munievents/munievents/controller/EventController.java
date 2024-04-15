package com.munievents.munievents.controller;

import com.munievents.munievents.entity.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    private ArrayList<Event> eventos;

    //TODO: constructor vacio para inicializar las variables  en este caso los Eventos
    //TODO: es buena practica inicializar las variables en el constructor de clase
    EventController(){
        eventos = new ArrayList<>();
        eventos.add(new Event(1,"Niky Nicole","La artista es representante de la nueva generación musical y una de las voces femeninas latinas más relevantes de la escena urbana nos presentará en directo su nuevo trabajo \"Alma\".","Viernes 25-04-2024", 150.00));
        eventos.add(new Event(2,"Niky Nicole","La artista es representante de la nueva generación musical y una de las voces femeninas latinas más relevantes de la escena urbana nos presentará en directo su nuevo trabajo \"Alma\".","Viernes 25-04-2024", 150.00));
        eventos.add(new Event(3,"Niky Nicole","La artista es representante de la nueva generación musical y una de las voces femeninas latinas más relevantes de la escena urbana nos presentará en directo su nuevo trabajo \"Alma\".","Viernes 25-04-2024", 150.00));
    }

    //TODO: obteniendo todos los eventos
    @GetMapping("/events")
    public List<Event> getAllEvents(){

        return eventos;
    }

    //TODO: obteniendo un evento por id
    @GetMapping("/events/{id}")
    public Optional<Event> getEventId(@PathVariable("id") int eventId) {
        eventId = eventId-1;
        return Optional.ofNullable(eventos.get(eventId));
    }

    //TODO: creacion de un evento nuevo
    @PostMapping("/evento")
    public String setEvent(@RequestBody Event event){
        String mensaje = "Evento insertado correctamente XD!!";
        if(event.getNameEvent().equals(null)){
            mensaje = "El nombre no puede ser nullo";
        }
        eventos.add(event);
        return mensaje;
    }


    //TODO: enviamos en en el body a un Evento y actualizamos por medio de id
    @PutMapping("/events/{id}")
    public String saveUpdateEvent(@PathVariable("id") int eventId, @RequestBody Event event) {
        // eventos.get(eventId).setId(event.getId());
        eventos.get(eventId).setNameEvent(event.getNameEvent());
        eventos.get(eventId).setDateEvent(event.getDateEvent());
        eventos.get(eventId).setPrice(event.getPrice());
        return "Usuario actualizado correctamente";
    }


    //TODO: elimina un evento por su id
    @DeleteMapping("/events/{id}")
    public String  deleteEventId(@PathVariable("id") int eventId) {
        eventos.remove(eventId);
        return "Evento eliminado correctamente!";
    }
}
