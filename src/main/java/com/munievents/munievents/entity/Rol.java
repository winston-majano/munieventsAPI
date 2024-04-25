package com.munievents.munievents.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Rol {
    @Id
    private int id;
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>(); 
} 