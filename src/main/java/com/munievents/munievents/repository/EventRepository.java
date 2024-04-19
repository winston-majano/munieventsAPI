package com.munievents.munievents.repository;

import com.munievents.munievents.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    //TODO: querys personalizadas
    @Query(value = "select e.title from Event e where  e.id = ?1")
     String getNameEventoById(Long id);


}
