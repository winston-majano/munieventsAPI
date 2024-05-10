package com.munievents.munievents.service;

import com.munievents.munievents.entity.Event;
import com.munievents.munievents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    //TODO: retornamos todos los eventos
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    //TODO: buscamos un evento por su id
    public Optional<Event> getEvent(int id) {
        return eventRepository.findById(id);
    }

    //TODO:crea un nuevo evento
    @PostMapping
    public void saveOrUpdate(@RequestBody Event event) {
        eventRepository.save(event);
    }

    //TODO: actualiza un evento
    @PutMapping
    public String  updateEvent( int eventId, @RequestBody Event event)
    {
        String message = "";
        if (!eventRepository.existsById(eventId) ) {
            message = "Error al actualziar el evento";
        } else {
            eventRepository.saveAndFlush(event);
            message = "Evento Actualizado correctamente";
        }
        return message;
    }


    //TODO: elimina un evento por su id
    public String  delete(int id) {
        String messaje = "";
        if(eventRepository.existsById(id)){
            eventRepository.deleteById(id);
            messaje = "Evento eliminado correctamente";
        }else{
            messaje = "Error al eliminar el registro o no existe ";
        }

       return messaje;
    }

    //TODO: implementando metodo personalizado de la entidad repositorio
    public String getNameEventoById(int id){
       String nombreEvento= String.valueOf(eventRepository.getNameEventoById(id));
        return "El evento es: "+nombreEvento;
    }


}
