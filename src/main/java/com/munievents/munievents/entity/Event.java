package com.munievents.munievents.entity;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String location;
    private double price;
    private LocalDateTime creation_date;

    //TODO: relacionamos la tabla de muchos a uno, muchos eventos tendran una sola categoria
    //@JsonIgnore

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int coins;

    // Lo dejo comentado porque da error.
     @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn(name = "event_id")
     private Set<Photos> photos;

}
