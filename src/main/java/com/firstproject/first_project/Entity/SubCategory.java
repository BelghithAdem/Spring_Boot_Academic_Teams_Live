package com.firstproject.first_project.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

public @Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String title;

    String description;

    @ManyToOne
    @JoinColumn(name = "id_category")
    Category category;

    @ManyToOne
    @JoinColumn(name = "id_product")
    Product product;


}
