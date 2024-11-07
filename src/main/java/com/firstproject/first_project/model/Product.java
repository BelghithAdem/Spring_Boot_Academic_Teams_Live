package com.firstproject.first_project.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String price;
    String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    List<SubCategory> subcategories;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.REMOVE)
    List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "id_provider")
    Provider provider;
}
