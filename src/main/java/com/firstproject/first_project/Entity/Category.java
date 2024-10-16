package com.firstproject.first_project.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String titre;

    String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    List<SubCategory> subcategories;


}
