package com.munievents.munievents.entity;


import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

}
