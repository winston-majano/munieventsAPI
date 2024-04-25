package com.munievents.munievents.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="rol")
@Data
public class Rol {
    @Id
    private int id;
    private String description;

    @ManyToMany
    private Set<User> users;
} 