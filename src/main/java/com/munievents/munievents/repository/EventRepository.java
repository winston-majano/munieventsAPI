package com.munievents.munievents.repository;

import com.munievents.munievents.entity.Event;


import com.munievents.munievents.entity.User;
import com.munievents.munievents.entity.dto.EventUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    //TODO: querys personalizadas
    @Query(value = "select e.title from Event e where  e.id = ?1")
    boolean getNameEventoById(int id);

    @Query(value = "select new com.munievents.munievents.entity.dto.EventUserDTO(e.id, e.title, e.description, e.start_date, e.end_date, e.location, e.price, e.coins, e.creation_date, e.category_id, e.user_id, e.photo) from Event e")
    List<EventUserDTO> findAllEvent();


    //le pasamos los parametros requeridos o los  campos que necesitamos
    @Query(value = "select new com.munievents.munievents.entity.dto.EventUserDTO(e.id, e.title, e.description, e.start_date, e.end_date, e.location, e.price, e.coins, e.creation_date, e.category_id, e.user_id, e.photo) from Event e where e.user_id =?1")
    List<EventUserDTO> findAllEventByUserId(int id);

}
