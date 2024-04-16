package com.munievents.munievents.repository;

import com.munievents.munievents.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    //@query("slect ")
    //private  String nombreyapellid();
}
