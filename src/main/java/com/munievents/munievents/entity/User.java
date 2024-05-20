package com.munievents.munievents.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
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
    //@JsonIgnoreProperties(value="password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String status;


  /*  @ManyToMany(cascade =  CascadeType.ALL )
    @JoinTable(
        name = "user_rol",
        joinColumns =  @JoinColumn(name = "users_id"),
        inverseJoinColumns = @JoinColumn(name = "user_rol_id") )
    //TODO: el JsonIgnoreProperties sirve para decirle al objeto json que propiedad no quires que se muestre
    @JsonIgnoreProperties(value="users")
    private Set<Rol> rol;
*/



}
