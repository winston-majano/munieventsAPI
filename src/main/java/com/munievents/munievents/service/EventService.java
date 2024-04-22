package com.munievents.munievents.service;

import com.munievents.munievents.entity.Event;
import com.munievents.munievents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Optional<Event> getEvent(Long id) {
        return eventRepository.findById(id);
    }

    //TODO:guarda o actualiza el evento
    @PostMapping
    public void saveOrUpdate(@RequestBody Event event) {
        eventRepository.save(event);
    }


    //TODO: elimina un evento por su id
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    //TODO: implementando metodo personalizado de la entidad repositorio
    public String getNameEventoById(Long id){
       String nombreEvento=  eventRepository.getNameEventoById(id);
        return "El evento es: "+nombreEvento;
    }


}
