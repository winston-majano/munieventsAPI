package com.munievents.munievents.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;



/*     @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "category_id")
     private Set<Event> events;
*/
}
