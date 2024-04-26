package com.munievents.munievents.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private int id;
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
     @JsonIgnore
     private Set<Photos> photos;

    @ManyToMany(cascade =  CascadeType.ALL )
    @JoinTable(
            name = "purchase",
            joinColumns =  @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id") )
    //@JsonIgnore
    private Set<User> user;


    @ManyToMany(cascade =  CascadeType.ALL )
    @JoinTable(
            name = "reviews",
            joinColumns =  @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id") )
    @JsonIgnore
    private Set<User> users;
}
