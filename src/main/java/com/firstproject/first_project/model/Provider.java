package com.firstproject.first_project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Provider extends User {
    String matricule;
    String service;
    String company;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.REMOVE)
    List<Product> product;
}
