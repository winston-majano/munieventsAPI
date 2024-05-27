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
    private String image_user; // Almacena la ruta del archivo
    private String email;
    private String phone;
    private String full_name;
    private String alias;
    private int qty_event_sub;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String status;

    
}