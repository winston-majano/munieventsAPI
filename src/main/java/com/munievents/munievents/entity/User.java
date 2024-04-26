package com.munievents.munievents.entity;


import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image_user;
    private String email;
    private String phone;
    private String full_name;
    private String alias;
    private int qty_event_sub;
    private String password;

    @ManyToMany(cascade =  CascadeType.ALL )
    @JoinTable(
        name = "user_rol",
        joinColumns =  @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "user_rol_id") )
    //TODO: el JsonIgnoreProperties sirve para decirle al objeto json que propiedad no quires que se muestre
    @JsonIgnoreProperties(value="users")
    private Set<Rol> rol;

    //TODO: cuando un usuario compra muchos eventos
  //  @ManyToMany
   // private Set<Event> events;

//    @ManyToMany(cascade =  CascadeType.ALL )
//    @JoinTable(
//            name = "reviews",
//            joinColumns =  @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "event_id") )
//    //TODO: el JsonIgnoreProperties sirve para decirle al objeto json que propiedad no quires que se muestre
//   // @JsonIgnoreProperties(value="users")
//    private Set<Event> eventSet;



}
